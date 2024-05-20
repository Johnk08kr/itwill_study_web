/**
 * object.html에 포함.
 */

// JSON(JavaScript Object Notation): 자바스크립트 객체 표기법.
// { property: value, ... }

const person = {
    name: '권요한',
    age: 32,
    phone: ['010-5037-9881', '02-6414-9881'],
};
console.log(person);

// 객체가 가지고 있는 property 접근:
// (1). 참조 연산자, (2). 인덱스 연산자
console.log(person.name); // 참조 연산자
console.log(person['age']); // 인덱스 연산자
console.log(person.phone[0]); // person['phone'][0]
console.log(person['phone'][1]);

person.name = 'Johnk'; // 객체의 property 값 변경.
console.log(person);

// 자바스크립트의 객체는, 객체가 생성된 이후에 property 추가 가능.
person.email = 'yohan1235@naver.com';
console.log(person);

// 메소드를 갖는 객체:
const score = {
    html: 100,
    css: 90,
    js: 82,
    // 객체의 property 접근시 this 키워드 
    sum: function() {
        return this.html + this.css + this.js;
    },
    avg: function() {
        return this.sum() / 3;
    },
};

console.log(score);
console.log(score.sum());
console.log(score.avg());

// 생성자 함수(constructor function): this 키워드를 사용해서 property를 선언한 함수.
function Score(html, css, js) {
    // field
    this.html = html;
    this.css = css;
    this.js = js;

    // method
    this.sum = function() {
        return this.html + this.css + this.js;
    };
    this.avg = function() {
        return this.sum() / 3;
    };
}

// 생성자 함수를 사용한 객체 생성: new 생성자함수();
const score1 = new Score(1, 2, 3);
console.log(score1);
console.log(score1.sum());
console.log(score1.avg());

const score2 = new Score(); // 모든 필드는 undefined가 됨.
console.log(score2);
console.log(score2.sum()); // undefined + undefined = NaN(Not a Number)

// 자바스크립트 객체는 for-in 구문에서 사용할 수 있음. -> property 이름들을 iteration.
const student = {
    no: 101,
    name: '오쌤',
    classNo: 10,
};
for (let x in student) {
    console.log(x, ':', student[x]);
}

// 클래스:
class Rectangle {
    // 생성자: 필드 초기화
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }

    // 메소드: function 키워드를 사용하지 않음!
    area() {
        return this.width * this.height;
    }

    perimeter() {
        return (this.width + this.height) * 2;
    }
}

// 클래스를 사용한 객체 생성:
const rect1 = new Rectangle(2, 3);
console.log(rect1);
console.log(`넓이 = ${rect1.area()}`);
console.log(`둘레 = ${rect1.perimeter()}`);

const rect2 = new Rectangle();
console.log(rect2);

// 원(Circle) 클래스 선언: 
class Circle {

    constructor(radius = 0) {
        this.radius = radius;
    }
    
    area() {
        return 3.14 * this.radius * this.radius;
    }
    
    perimeter() {
        return 2 * 3.14 * this.radius;
    }
}

const circle1 = new Circle(4);
console.log(`넓이 = ${circle1.area()}`);
console.log(`둘레 = ${circle1.perimeter()}`);

const circle2 = new Circle();
console.log(`넓이 = ${circle2.area()}`);
console.log(`둘레 = ${circle2.perimeter()}`);

