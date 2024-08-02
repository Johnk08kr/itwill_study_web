/**
 * comments.js
 * /post/details.html에 포함
 * 댓글 생성, 목록, 수정, 삭제.
 */
document.addEventListener("DOMContentLoaded", () => {

    let currentPageNo = 0; // 현재 댓글 목록의 페이지 번호
    // bootstrap 라이브러리의 Collapse 객체를 생성:
    const bsCollapse = new bootstrap.Collapse("div#collapseComments", { toggle: false });

    // [댓글 보기] 버튼에 클릭 이벤트 리스너 설정.
    const $btnToggle = document.querySelector("button#btnToggle");
    $btnToggle.addEventListener("click", () => {
        bsCollapse.toggle(); // Collapse 객체를 보기/감추기 토글

        const toggle = $btnToggle.getAttribute("data-toggle");
        if (toggle === "collapse") {
            $btnToggle.innerHTML = "Hide Comments";
            $btnToggle.setAttribute("data-toggle", "unfold");

            // 댓글 목록 불러오기
            getAllComments(0);
        } else {
            $btnToggle.innerHTML = "Show Comments";
            $btnToggle.setAttribute("data-toggle", "collapse");
        }
    });

    // 댓글 [등록] 버튼을 찾아서, 클릭 이벤트 리스너 설정.
    const $btnRegisterComment = document.querySelector("button#btnRegisterComment");
    $btnRegisterComment.addEventListener("click", registerComment);

    // 댓글 [더보기] 버튼을 찾아서, 클릭 이벤트 리스너 설정.
    const $btnMoreComment = document.querySelector("button#btnMoreComment");
    $btnMoreComment.addEventListener("click", () => getAllComments(currentPageNo + 1));

    // ----- function -----
    // 댓글 등록
    function registerComment() {
        // 댓글이 달린 포스트의 아이디
        const postId = document.querySelector("input#id").value;
        // 댓글 내용
        const ctext = document.querySelector("textarea#commentText").value;
        // 댓글 작성자
        const writer = document.querySelector("input#commentWriter").value;

        if (ctext.trim() === '') {
            alert("댓글 입력해");
            return;
        }

        // Ajax 요청에서 보낼 데이터
        const data = { postId, ctext, writer };

        // Ajax POST 요청
        axios
            .post("/api/comment", data)
            .then(response => {
                console.log(response.data);
                alert("댓글 등록 성공");

                // 댓글 입력 창 비움
                document.querySelector("textarea#commentText").value = ' ';
                // 댓글 목록 갱신
                getAllComments(0);
            })
            .catch(error => console.log(error));
    }

    // 댓글 불러오기
    function getAllComments(pageNo) {
        // 댓글들이 달린 포스트 아이디
        postId = document.querySelector("input#id").value;

        // Ajax 요청을 보낼 주소
        // path variable 댓글이 달린 포스트 아이디. requestParam: 페이지 번호
        const uri = `/api/comment/all/${postId}?p=${pageNo}`;

        // Ajax 요청을 보내고, 성공/실패 콜백 설정
        axios.get(uri)
            .then((response) => {
                console.log(response);
                currentPageNo = response.data.number;
                makeCommentElement(response.data.content, response.data.number);
                if (response.data.content.length < 5) {
                    $btnMoreComment.disabled = true;
                } else {
                    $btnMoreComment.style.display = "block";
                }
            })
            .catch(error => console.log(error));
    }

    // 불러온 댓글 보여주기
    function makeCommentElement(data, pageNo) {
        const $sectionComments = document.querySelector("div#sectionComments");

        let htmlStr = ""; // div에 삽입할 html 코드(댓글 목록)
        for (let comment of data) {
            htmlStr += `
            <div class="custom-comment-card">
              <div class="custom-comment-header">
                <span class="fw-bold">${comment.writer}</span>
                <span class="text-secondary">${formatedDate(comment.modifiedTime)}</span>
              </div>
              <div class="custom-comment-body">
                <textarea class="form-control" rows="3">${comment.ctext}</textarea>
              </div>
              <div class="custom-comment-buttons" style="justify-content: end">
                <button class="btnUpdateComment btn btn-outline-success data-id="${comment.id}">update</button>
                <button class="btnDeleteComment btn btn-outline-danger" data-id="${comment.id}">delete</button>
              </div>
            </div>
            `;
        }

        if (pageNo === 0) {
            $sectionComments.innerHTML = htmlStr;
        } else {
            $sectionComments.innerHTML += htmlStr;
        }

        // 댓글 [수정] 버튼을 찾아서, 클릭 이벤트 리스너 설정.
        //const $btnUpdateComment = document.querySelector("button#btnUpdateComment");
        // $btnUpdateComment.addEventListener("click", () => updateComment);

        // 모든 삭제 버튼을 선택
        const $$btnDeleteComment = document.querySelectorAll(".btnDeleteComment");

        $$btnDeleteComment.forEach(button => {
            const id = button.getAttribute("data-id");
            button.addEventListener("click", () => deleteComment(id));
        });

    }

    function deleteComment(id) {
        console.log("deleteComment" + id);
    }

    // Date formatting
    function formatedDate(dateString) {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        const hours = String(date.getHours()).padStart(2, '0');
        const minutes = String(date.getMinutes()).padStart(2, '0');
        return `${year}-${month}-${day} ${hours}:${minutes}`;
    }
});
