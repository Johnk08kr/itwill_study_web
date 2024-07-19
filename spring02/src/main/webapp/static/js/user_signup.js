document.addEventListener('DOMContentLoaded', () => {
    let useridChecked = false; // 사용자 아이디 중복 체크 결과. true: 사용 가능 아이디.
    let passwordChecked = false; // 비밀번호 필드 작성 여부 체크
    let emailChecked = false;
    const regex = /^\s+$/;

    const inputUserid = document.querySelector('input#userid');
    inputUserid.addEventListener('change', checkUserid);

    const inputPassword = document.querySelector('input#password');
    inputPassword.addEventListener('change', checkPassword);

    const inputEmail = document.querySelector('input#email');
    inputEmail.addEventListener('change', checkEmail);


    /* -------------------- 함수 선언 ------------------------*/

    // 회원 가입 버튼 활성화/비활성화
    function changeButtonState() {
        const $btnSignUp = document.querySelector('button#btnSignUp');

        if (useridChecked && passwordChecked && emailChecked) {
            // 버튼의 class 속성 값들 중 'disabled'를 제거. -> 버튼활성화
            $btnSignUp.classList.remove('disabled');
        } else {
            // 버튼의 class 속성에 'disabled' 추가. -> 버튼 비활성화
            $btnSignUp.classList.add('disabled');
        }
    }

    // userid 입력 필드의 change 이벤트 리스너
    function checkUserid(event) {
        // 중복 아이디 체크 Ajax 요청을 보내고, 응답을 받았을 때 처리.
        const userid = event.target.value;
        console.log(userid);

        const uri = `./checkid?userid=${userid}`;
        axios
            .get(uri)
            .then((response) => {
                const $checkUseridResult = document.querySelector('div#checkUseridResult')

                if (response.data === 'Y') {
                    useridChecked = true;
                    $checkUseridResult.innerHTML = '멋진 아이디 입니다.';
                    $checkUseridResult.classList.add('text-success');
                    $checkUseridResult.classList.remove('text-danger');
                } else {
                    useridChecked = false;
                    $checkUseridResult.innerHTML = '사용할 수 없는 아이디입니다.'
                    $checkUseridResult.classList.add('text-danger');
                    $checkUseridResult.classList.remove('text-success');
                }

                changeButtonState(); // 버튼 활성화 여부를 변경
            })
            .catch((error) => console.log(error))
    }

    // 비밀번호 입력 필드의 change 이벤트 리스너
    function checkPassword(event) {
        // input#password 비어있는지 체크
        if (regex.test(event.target.value)){
          passwordChecked =false;
        } else {
          passwordChecked = true;
        }
        changeButtonState();
    }

    // 이메일 입력 필드의 change 이벤트 리스너
    function checkEmail(event) {
        // input#email 비어있는지 체크
        if (regex.test(event.target.value)){
          emailChecked =false;
        } else {
          emailChecked = true;
        }
        changeButtonState();
    }

});
