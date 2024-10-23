# 코디 서비스
코디 상품 추천 기능 제공을 목표로 하는 API 서비스를 개발했습니다.

## 사용 기술
* JAVA 21
* SpringBoot 3.3.4
   * spring-boot-starter-web
   * spring-boot-starter-data-jpa
* H2 Database
* Gradle

## 구현 내용 및 범위

### 아키텍처 설계
대규모 서비스에서 프로젝트 구성의 유연성과 확장성, 코드의 응집도를 높일 수 있는 Gradle 멀티 모듈 구조와 헥사고날 아키텍처를 적용하여 API 서비스를 개발했습니다.

* 헥사고날 아키텍처 구성(4개의 헥사곤으로 구분)
  * Bootstrap Hexagon
    * 외부에서 요청을 받는 Driving Adapter 이면서 동시에 서비스 실행을 위한 구성을 하는 영역
    * 구현: coordi-rest-api
  * Application Hexagon
    * 서비스하고자 하는 비즈니스 로직에 대한 핵심 영역
    * Domain 을 이용하여 Adapter 코드에 영향을 받지 않게 로직 작성
    * 구현: coordi-core
  * Domain Hexagon
    * 서비스를 구성하는 주요 도메인 모델에 대한 영역
    * 구현: coordi-product
  * Infrastructure Hexagon
    * Driven Adapter 로 인프라에 대한 영역
    * 구현: coordi-storage-h2

### 구현 기능 목록
1. 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
2. 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을
   조회하는 API
3. 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
4. 브랜드와 카테고리, 상품을 추가 / 업데이트 / 삭제하는 API 

### API 목록 및 테스트

#### 1.카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API

Request
```shell
curl -X GET http://localhost:8080/api/v1/recommendations/min-price-products/category
```

Response
```json
{
    "totalPrice": 34100,
    "products": [
        {
            "categoryName": "상의",
            "brandName": "C",
            "price": 10000
        },
        {
            "categoryName": "아우터",
            "brandName": "E",
            "price": 5000
        },
        {
            "categoryName": "바지",
            "brandName": "D",
            "price": 3000
        },
        {
            "categoryName": "스니커즈",
            "brandName": "A",
            "price": 9000
        },
        {
            "categoryName": "가방",
            "brandName": "A",
            "price": 2000
        },
        {
            "categoryName": "모자",
            "brandName": "D",
            "price": 1500
        },
        {
            "categoryName": "양말",
            "brandName": "I",
            "price": 1700
        },
        {
            "categoryName": "액세서리",
            "brandName": "F",
            "price": 1900
        }
    ]
}
```

#### 2.단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API

Request
```shell
curl -X GET http://localhost:8080/api/v1/recommendations/min-price-products/single-brand
```

Response
```json
{
    "minPrice": {
        "brand": "D",
        "products": [
            {
                "categoryName": "모자",
                "price": 1500
            },
            {
                "categoryName": "액세서리",
                "price": 2000
            },
            {
                "categoryName": "양말",
                "price": 2400
            },
            {
                "categoryName": "가방",
                "price": 2500
            },
            {
                "categoryName": "바지",
                "price": 3000
            },
            {
                "categoryName": "아우터",
                "price": 5100
            },
            {
                "categoryName": "스니커즈",
                "price": 9500
            },
            {
                "categoryName": "상의",
                "price": 10100
            }
        ],
        "totalPrice": 36100
    }
}
```

#### 3. 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API

Request
```shell
curl -G http://localhost:8080/api/v1/recommendations/min-max-price-products --data-urlencode "categoryName=상의"
```

Response
```json
{
  "categoryName": "상의",
  "minPrice": [
    {
      "brandName": "C",
      "price": 10000
    }
  ],
  "maxPrice": [
    {
      "brandName": "I",
      "price": 11400
    }
  ]
}
```

#### 4. 브랜드와 카테고리, 상품을 추가 / 업데이트 / 삭제하는 API
POST, PUT 요청은 RequestBody 로 등록/수정 요청.

1. 카테고리 API
* 등록: POST http://localhost:8080/api/v1/categories
* 조회: GET http://localhost:8080/api/v1/categories/1
* 수정: PUT http://localhost:8080/api/v1/categories/1
* 삭제: DELETE http://localhost:8080/api/v1/categories/1

2. 브랜드 API
* 등록: POST http://localhost:8080/api/v1/brands
* 조회: GET http://localhost:8080/api/v1/brands/1
* 수정: PUT http://localhost:8080/api/v1/brands/1
* 삭제: DELETE http://localhost:8080/api/v1/brands/1

3. 상품 API
* 등록: POST http://localhost:8080/api/v1/products
* 조회: GET http://localhost:8080/api/v1/products/1
* 수정: PUT http://localhost:8080/api/v1/products/1
* 삭제: DELETE http://localhost:8080/api/v1/products/1

### 기타 추가 정보
- ExceptionHandler 로 Exception 공통 처리
- 상품 데이터에 등록된 브랜드와 카테고리가 DB 에서 삭제되면 나중에 어떤 정보였는지 확인이 어렵기에 soft delete 처리  

## 코드 빌드 및 실행 방법
#### 빌드
Github 의 소스를 Clone 받은 후, 쉘에서 프로젝트 디렉터리로 이동하여 아래의 명령어로 빌드.

```shell
./gradlew :bootstrap:coordi-rest-api:build
```

#### 실행
빌드 완료 후, 아래 명령어로 빌드된 jar 파일을 실행. 
```shell
java -jar ./bootstrap/coordi-rest-api/build/libs/coordi-rest-api-0.0.1-SNAPSHOT.jar
```
