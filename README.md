# msa-bbs
## 12.25 정리
* spring-security 설정하면 처음 id, passwd는 user/console에 뜨는거 입력하기.
* DB->Mapper->Service->Controller->html
  * 백 -> 프론트 순으로 만듬
  * 기존 msa-member 참고함
  * 근데 왜 template parsing (template: "class path resource [templates/manager/bbs_master_list.html]") 에러가 뜨는지 모르겠음.
    * => @Data 가 Getter, Setter를 못 불러와서 그런듯. member에서도 이랬었는데 왜 이러지?
    * => 강제로 Getter, Setter 주입하니까 화면에 데이터 뿌리기까지 성공