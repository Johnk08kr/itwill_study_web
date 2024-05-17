/**
 * array.html에 포함
 * 
 * JS 배열(array): 여러 개의 원소(아이템)들을 하나의 변수 이름으로 저장하기 위한 타입.
 * 자바 배열: '한가지' 타입의 값들 여러 개를 저장하는 타입.
 * 자바스크립트 배열에서는 다른 타입의 값들이 저장될 수 있음.
 * 
 */
// div#output인 요소를 찾음:
const output = document.querySelector('div#output');

// 배열 선언 & 초기화:
const arr = [1, 2, 30, 40, -5]; // 자바: int[] arr = {1, 2, 3};

// 배열 arr의 내용을 output 영역에 씀.
let html = '';
for (let i = 0; i < arr.length; i++) {
    html += `${arr[i]}, `;
}
output.innerHTML += html + '<br/>';

// 자바 향상된 for 문장: for (변수 선언 : 배열){ ... }

// for-of 문장: 배열의 원소(아이템)들을 iteration(순회).
html = '';
for (let val of arr) {
    html += `${val}, `;
}
output.innerHTML += html + '<br/>';

// for-in 문장: 배열의 인덱스들을 iteration(순회).
html = '';
for (let idx in arr) {
    html += `${idx}: ${arr[idx]}, `;
}
output.innerHTML += html + '<br/>';

// 배열 arr의 원소들의 합계, 평균을 output에 출력.
html = '';
let tot = 0;
let avg = 0;
for (let val of arr) {
    tot += val;
}
html += `합계: ${tot} <br/> 평균: ${tot / arr.length}`;
output.innerHTML += html + '<br/>';

// 배열의 원소들을 ul의 li 요소로 만듦: 
const list = document.querySelector('ul#list');
const drama = ['삼식이 삼촌', '동조자', '삼체'];
html = '';
for (let val of drama) {
    html += `
        <li>${val}</li>
    `;
}
list.innerHTML += html;
