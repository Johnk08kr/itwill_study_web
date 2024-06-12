/**
 *
 */

document.addEventListener('DOMContentLoaded', () => {
    const updateForm = document.querySelector('form#updateForm');
    const inputId = document.querySelector('input#id');
    const inputTitle = document.querySelector('input#title');
    const textContent = document.querySelector('textarea#content');
    const btnDelete = document.querySelector('button#btnDelete');
    const btnUpdate = document.querySelector('button#btnUpdate');

    btnDelete.addEventListener('click', () => {
        const result = confirm('증말?');
        if (result) {
            // GET 방식의 delete 요청을 서버로 보냄.
            location.href = `delete?id=${inputId.value}`;
        }
    });

    btnUpdate.addEventListener('click', () => {
        // 제목과 내용이 비어있는 지 체크:
        const title = inputTitle.value; // input 요소에 입력된 값.
        const content = textContent.value; // textarea 요소에 입력된 값.
        if (title === '' || content === '') {
            alert('제목과 내용은 반드시 입력해야 합니다!');
            return; // 함수 종료
        }

        const result = confirm('변경된 내용을 저장할까요?');
        if (result) {
            updateForm.method = 'post'; // 폼 제출 방식 설정.
            updateForm.action = 'update'; // 폼 제출 요청 주소 설정.
            updateForm.submit(); // 폼 제출(서버로 요청을 보냄).
        }
    });
});
