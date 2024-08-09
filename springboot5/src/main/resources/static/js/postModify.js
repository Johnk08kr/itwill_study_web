const $deleteBtn = document.querySelector("#deleteBtn");
$deleteBtn.addEventListener("click", () => {
    const check = confirm("진짜?");
    if (check) {
        const postId = document.querySelector("#id").value;
        location.href = `/post/delete/${postId}`;
    }
});
