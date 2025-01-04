# msa-bbs
## 12.25 정리
* 게시판 목록조회까지
* spring-security 설정하면 처음 id, passwd는 user/console에 뜨는거 입력하기.
* DB->Mapper->Service->Controller->html
  * 백 -> 프론트 순으로 만듬
  * 기존 msa-member 참고함
  * 근데 왜 template parsing (template: "class path resource [templates/manager/bbs_master_list.html]") 에러가 뜨는지 모르겠음.
    * => @Data 가 Getter, Setter를 못 불러와서 그런듯. member에서도 이랬었는데 왜 이러지?
    * => 강제로 Getter, Setter 주입하니까 화면에 데이터 뿌리기까지 성공
      * 해결방법 ====>> ![img.png](img/img.png) 두 개 체크해줘야 함.

## 12.26 정리
* 게시판 등록, 수정까지
* controller 하나로 다 이동가능. checkModel()로 분기
```java
@RequestMapping(value = "/{dirPath}/{pageName}.page")
    public String dynamicPage(@PathVariable("dirPath") String dirPath, @PathVariable("pageName") String pageName, Model model) {
        checkModel(pageName, "", model);
        return "/" + dirPath + "/" + pageName;
    }
```
* html 파일 하나로 등록과 수정을 같이 이용.
```html
<button type="button" th:if="${bbsId == '' || bbsId == null}"     class="btn btn-primary" onclick="save('CREATE')"><span th:text="${btnName}">등록</span></button>
<button type="button" th:unless="${bbsId == '' || bbsId == null}" class="btn btn-primary" onclick="save('UPDATE')"><span th:text="${btnName}">수정</span></button>
```
```shell
var url = '';
if (mode === 'CREATE') {
    url = '/manager/create_bbs_master.do';
} else {
    url = '/manager/update_bbs_master.do';
}
```

## 12.29 정리
* 삭제 기능
  ```shell
  <a class="btn btn-sm btn-danger" th:attr="data-bbs-id=${bbs.bbsId}" onclick="deleteBbsMaster(this)">삭제</a>
  ```
  * thymleaf에서는 문자열 데이터를 이벤트 핸들러 속성에 직접 사용하려고 하면 보안상의 이유로 제한 발생. 숫자나 boolean 값만 신뢰함.
    * 해결방법 => data-* 속성을 사용.

### 재가동하지 않고 변경사항 반영하기
  1. application.properties설정
  ```properties
  spring.thymeleaf.cache=false
  spring.thymeleaf.prefix=classpath:/templates/
  spring.thymeleaf.suffix=.html
  ```
  2. spring boot devtools 사용
  ```xml
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
  </dependency>
  ```
  3. File > Settings > Advanced Settings > Allow auto-make to start even if developed application is currently running 활성화
  
* 게시글 기능 DB 설계 및 생성완료 PPT참고

## 12.30 정리
* 게시글 조회
* bbs_ main / master 분리
* 게시글 조회 할 때 sql에서 join해서 가져오면 중복됌.(ex) 첨부파일이 두 개, 댓글이 두 개면 총 네 개가 조회되어버림.)
* 각자 조회해오는 service를 만들고, controller단에서 조합해서 화면으로 던져주기
* 잘 안 될때는 일단 코딩해보고 중복되는 부분을 변수화하고, 하나로 합치기. 하드코딩X!

## 01.04 정리
* 게시글 댓글 기능
* 리다이렉션 안 하고 리스트 밑에 append()
* 시간 관련
  1. sql에서 now()로 시간 넣기
    * now()로 넣고, 댓글 조회해와서 result.put() 하기  ==> 이게 제일 좋은 방법 나중에 보안도 생각하면..
  2. java에서 시간 넣기
  3. javascript에서 시간 넣기