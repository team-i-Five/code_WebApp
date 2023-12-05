# code_WebApp

### 홈 화면

![image](https://github.com/team-i-Five/code_WebApp/assets/31847834/8b1924ce-b3ef-4d19-b422-fc776aacc90c)

### 대표 화면 - 태그 선택 및 뮤지컬 리스트 화면
![image](https://github.com/team-i-Five/code_WebApp/assets/31847834/ae7ed116-3dd3-4eeb-95a9-be9504dea3b9)

### `web/` code tree

- java
```
web/src/main/java/com/ifive/front/
├── domain
│   ├── Future
│   │   ├── MusicalFuture.java
│   │   ├── MusicalFutureDTO.java
│   │   ├── MusicalFutureRepository.java
│   │   ├── MusicalFutureService.java
│   │   └── MusicalFutureServiceImpl.java
│   ├── Member
│   │   ├── IfiveMember.java
│   │   ├── IfiveMemberController.java
│   │   ├── IfiveMemberRepository.java
│   │   ├── IfiveMemberSecurityService.java
│   │   ├── IfiveMemberSecurityServiceImpl.java
│   │   ├── IfiveMemberService.java
│   │   ├── IfiveMemberServiceImpl.java
│   │   ├── MemberCreateForm.java
│   │   └── MemberRole.java
│   ├── Past
│   │   ├── MusicalPast.java
│   │   ├── MusicalPastController.java
│   │   ├── MusicalPastDTO.java
│   │   ├── MusicalPastRepository.java
│   │   ├── MusicalPastService.java
│   │   └── MusicalPastServiceImpl.java
│   ├── Present
│   │   ├── MusicalPresent.java
│   │   ├── MusicalPresentDTO.java
│   │   ├── MusicalPresentRepository.java
│   │   ├── MusicalPresentService.java
│   │   └── MusicalPresentServiceImpl.java
│   └── Rank
│       ├── MusicalRank.java
│       ├── MusicalRankController.java
│       ├── MusicalRankDTO.java
│       ├── MusicalRankRepository.java
│       ├── MusicalRankService.java
│       └── MusicalRankServiceImpl.java
└── global
    ├── config
    │   ├── RestTemplateConfig.java
    │   └── SecurityConfig.java
    └── controller
        ├── FrontController.java
        ├── RecommnedResultController.java
        └── SearchController.java
```

- resources
```
web/src/main/resources
├── application-aws.properties
├── application.properties
├── static
│   ├── domain
│   │   ├── Member
│   │   │   ├── signin.js
│   │   │   ├── signin_form.css
│   │   │   └── signup_form.css
│   │   ├── Rank
│   │   │   └── rank.css
│   │   ├── Search
│   │   │   ├── search.css
│   │   │   └── search.js
│   │   └── Tag
│   │       ├── init_tag.css
│   │       ├── tag_list.css
│   │       └── tag_list.js
│   ├── fonts
│   │   ├── NotoSansKR-Medium.ttf
│   │   └── NotoSansKR-Medium.woff
│   ├── fragment
│   │   ├── musical_info.js
│   │   ├── nav.css
│   │   ├── slider.css
│   │   └── slider.js
│   ├── global
│   │   ├── index.css
│   │   ├── index.js
│   │   └── recommendResult.css
│   └── img
│       └── mumo_logo.png
└── templates
    ├── domain
    │   ├── Member
    │   │   ├── signin_form.html
    │   │   └── signup_form.html
    │   ├── Rank
    │   │   ├── rank_interpark.html
    │   │   ├── rank_ticketlink.html
    │   │   └── rank_yes24ticket.html
    │   ├── Search
    │   │   ├── null_search.html
    │   │   └── search.html
    │   └── Tag
    │       ├── all_tags_list.html
    │       ├── init_tag.html
    │       ├── null_tag.html
    │       └── tag_list.html
    ├── fragment
    │   ├── common.html
    │   ├── common_nav.html
    │   ├── common_tag.html
    │   ├── form_errors.html
    │   └── musical_list_slider.html
    └── global
        ├── error.html
        ├── index.html
        └── recommendResult.html
```

### Deploy

- AWS EC2 활용 - [mumo 사이트](http://15.164.103.164:8080/)

```
$ cd web/

$ docker build -t mumo-image .

$ docker run -d --name mumo-container -p 8080:8081 mumo-image
# application.properties 파일 내에 "server.port = 8081" 로 정의했기 때문에
## 8080포트로 접속해 컨테이너의 8081 포트를 이용했습니다. 
```
