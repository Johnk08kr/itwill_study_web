/**
 * event.html에 포함
 */

const output = document.querySelector('div#output');
const btnInput = document.querySelector('button#btnInput');
btnInput.addEventListener('click', function(e) {
    //console.log(e); // PointerEvent

    const itemInput = document.querySelector('input#itemInput');
    //const output = document.querySelector('div#output');
    const itemList = document.querySelector('ul#itemList');
    //output.innerHTML = itemInput.value;
    itemList.innerHTML += `<li> ${itemInput.value} </li>`;
    itemInput.value = '';
});

// TODO: input#itemInput2 요소에 'keydown' 이벤트 리스너를 등록:
// 엔터키가 눌렸을 때, input에 입력된 내용을 ul#itemList2의 리스트 아이템으로 추가.
const itemInput2 = document.querySelector('input#itemInput2');
itemInput2.addEventListener('keydown', function(e) {
    if (e.keyCode == 13) {
        const itemList2 = document.querySelector('ul#itemList2');
        itemList2.innerHTML += `<li> ${itemInput2.value} </li>`;
        itemInput2.value = '';
    }
});

// TODO: input#username 요소에 'change' 이벤트 리스너를 등록:
// input에 입력된 내용이 바뀔 때마다 div를 입력 내용으로 덮어씀.
const userName = document.querySelector('input#username');
userName.addEventListener('change', function() {
    const output = document.querySelector('div#output');
    output.innerHTML = userName.value;
    userName.value = '';
});
// TODO: img#bulb 요소에 'mouseenter' 이벤트 리스너를 등록:
// img의 src를 'images/bulb_on.gif'로 변경.
bulb.addEventListener('mouseenter', function() {
    const bulb = document.querySelector('img#bulb');
    bulb.src = 'images/bulb_on.gif';
});
// TODO: img#bulb 요소에 'mouseleave' 이벤트 리스너를 등록:
// img의 src를 'images/bulb_off.gif'로 변경.
bulb.addEventListener('mouseleave', function() {
    const bulb = document.querySelector('img#bulb');
    bulb.src = 'images/bulb_off.gif';
});
