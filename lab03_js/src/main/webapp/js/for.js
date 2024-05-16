/**
 * for.html에 포함
 */

// Id가 result인 HTML 요소 
const result = document.getElementById('result');

// result 요소에 추가할 HTML 코드를 저장하기 위한 문자열 변수:
let html = '';

for (let x = 2; x < 10; x++) {
    html += `2 x ${x} = ${2 * x} <br/>`;
}
result.innerHTML += html;
result.innerHTML += '<hr/>';
html = '';

for (let x = 3; x < 10; x++) {
    for (let y = 1; y < 10; y++) {
        html += `${x} x ${y} = ${x * y} <br/>`;
    }
    result.innerHTML += html;
    result.innerHTML += '<hr/>';
    html = '';
}

// break를 사용해서 2단은 2*2까지..9단은 9*9까지 
for (let x = 2; x < 10; x++) {
    for (let y = 1; y < 10; y++) {
        html += `${x} x ${y} = ${x * y} <br/>`;
        if (x == y) {
            break;
        }
    }
    result.innerHTML += html;
    result.innerHTML += '<hr/>';
    html = '';
}