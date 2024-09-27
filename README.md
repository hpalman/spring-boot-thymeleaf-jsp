spring boot jsp/jstl + thymeleaf

<h2>
  https://github.com/hpalman/spring-boot-thymeleaf-jsp
</h2>

참고>

https://islet4you.tistory.com/entry/SpringBoot-SpringBoot-30-에서-Jsp-Jstl-세팅-그리고-Servlet-변경점

https://github.com/thymeleaf/thymeleaf/blob/3.1-master/examples/spring6/thymeleaf-examples-spring6-thvsjsp


■ https://victorydntmd.tistory.com/340

thymeleaf에서 MessageSource의 메시지를 가져오기 위해서는 #{속성명}을 작성해주면 됩니다.
즉, product, product.category는 messages.properties 파일에서 언어별로 텍스트를 정의해줄 것입니다.

3) messages.properties
다음으로 messages_{언어코드}_{국가코드}.properties 파일에 번역 텍스트를 작성해줍니다.

messages.properties 파일은 사용자 언어 환경에 맞는 properties 파일이 없을 경우, 기본 값으로 보여지는 파일입니다.

각 properties 파일에서 텍스트를 작성하기 전에 IDE에서 *.properties 파일의 인코딩을 UTF-8로 설정해주도록 합니다.

그렇지 않으면 한글 등의 문자가 깨짐 현상이 발생합니다.
