/* 250512(월) 1일차 */
-- 한 줄 주석
/* 범위 주석 */
/* 
    여러 줄
    주석
*/

select * from emp; -- emp 테이블을 불러옴 
select * from dept; -- dept 테이블을 불러옴 
select * from salgrade; -- salgrade 테이블을 불러옴 

select EMPNO, ENAME, DEPTNO -- EMP 테이블에 있는 empno, ename, deptno 열을 불러옴
    from EMP; -- 여러 사람이 보기 좋게 줄바꿈을 넣음 

-- 이름과 급여만 출력
select ENAME, SAL
    from EMP;

select ENAME, SAL,
    123, 'a' /* 내가 원하는 데이터 값을 넣을 수 있음 */
    from EMP;
    
-- DISTINCT : 중복 데이터 삭제 
select 
    deptno 
from emp;
    
select 
    distinct deptno
from emp;

select 
   distinct job, deptno
from emp; /* job과 deptno에서 중복되는 일부 데이터만 출력됨 */

select 
   /*distinct*/ job, deptno
from emp; 

-- 열과 연산식
select ename, sal, sal*12+comm, comm
from emp;

/* column의 별칭 지정하기 */
select ename, sal, 
    sal*12+comm as S1,
    sal*12+comm S2, 
    sal*12+comm "s s",  -- sql에서 유일하게 ""를 사용 : 별칭 지정할 때
    comm as 추가수당
from emp;



/* 250513(화) */
/* ORDER BY (Order: 정렬하다) */
select * from EMP
order by SAL; -- 자동으로 오름차순으로 정렬됨. 생략가능. 오름차순 : ASC(ascending) 
    -- 오름차순 : 작은 것부터 큰 것 순서로 정렬

select * from EMP
order by SAL desc; -- 내림차순 : desc(descending)

select * from EMP  -- 가장 먼저 입사한 순서로 출력
order by HIREDATE;

select * from EMP  -- 부서명 오름차순->급여 내림차순으로 정렬하기
order by DEPTNO asc, SAL desc; -- 부서명이 동일할 시 급여 내림차순으로 정렬됨

select * from EMP  -- 부서명 오름차순->급여 내림차순->사원번호 내림차순으로 정렬하기
order by DEPTNO asc, SAL desc, EMPNO desc; 

-- 책 97쪽 3번 문제
select EMPNO AS EMPLOYEE_NO, 
        ENAME AS EMPLOYEE_NAME,
        JOB,
        MGR AS MANAGER,
        HIREDATE,
        SAL AS SALARY,
        COMM AS COMISSION,
        DEPTNO AS DEPARTMENT_NO
from EMP
ORDER BY DEPTNO DESC, ENAME ASC;

/* 어제 복습 */
select distinct deptno from emp; -- 중복을 제외하고 보여줌

/* where절 */
select * from EMP
where DEPTNO = 30; -- 부서 번호가 30인 행만 출력

-- AND 연산자
select * from EMP
where DEPTNO = 30 and JOB = 'SALESMAN';

-- OR 연산자
/* EMP 테이블에서 부서 번호가 30이거나(또는) 직책이 CLERK인 사원 모든 정보를 출력하라 */
select * from EMP
where DEPTNO = 30 or JOB = 'CLERK';

-- where절 + order by문 순으로 후술됨. 그렇게 설계되어있음.
select * from EMP
where DEPTNO = 30 -- 부서 번호가 30인 행만 출력
order by HIREDATE asc; -- 입사순으로 정렬
-- 조건문도 순서가 있음

-- sal이 1600인 사람만 출력
select * from EMP
Where SAL = 1600;

-- sal이 1600 이상인 사람만 출력
select * from EMP
Where SAL >= 1600;

-- sal이 1600 초과인 사람만 출력
select * from EMP
Where SAL > 1600;

-- sal이 1600 이하인 사람만 출력
select * from EMP
Where SAL <= 1600;

-- 부정
select * from EMP Where DEPTNO != 30;
select * from EMP Where DEPTNO <> 30;

/* job이 CLERK이거나 sal이 2000 초과면서 deptno가 10인 사원 조회 */
select * from emp
where job = 'CLERK' or (sal > 2000 and deptno = 10);

-- NOT
select * from emp
where not (job = 'CLERK' or (sal > 2000 and deptno = 10));

/* deptno !=30. deptno <> 30, deptno ^= 30, not deptno = 30 */

/* 월급 2000 이상 4000 미만인 사원을 출력하라 */
select * from EMP
where SAL >= 2000 and SAL < 4000;
-- 2000 <= sal < 4000는 안됨. 뒤의 4000을 참/거짓으로 판단할 수 없기 때문에

-- IN 연산자
/* 부서번호 10 또는 20인 사원만 출력*/
select * from EMP
where DEPTNO = 10 or DEPTNO = 20;

select * from EMP
where DEPTNO in(10, 20);

/* 부서번호 10 또는 20가 아닌 사원만 출력*/
select * from EMP
where DEPTNO not in(10, 20);



/* 250514(수) */
-- 퀴즈
/* 1. 부서 번호 10번인 사람들을 출력 */
select * from EMP
where DEPTNO = 10;

/* 2. 부서 번호 10번이 아닌 사람들을 출력 */
select * from EMP
where not (DEPTNO = 10);
-- where DEPTNO != 10;

/* 3. 급여가 3000 이상인 사람들을 출력 */
select * from EMP
where SAL >= 3000;

/* 4. 급여가 1500~3000 사이(포함)의 사람을 출력 */
select * from EMP
where SAL between 1500 and 3000; -- between은 오라클 전용
-- where SAL >= 1500 and SAL <= 3000;

/* 5. 부서 번호 10번인 사람 중(AND) 급여 2000 이상인 사람을 출력 */
select * from EMP
where DEPTNO = 10 and SAL >= 2000;

/* 6. 부서 번호 30번 중 1500~3000 사이(미포함)인 사람을 출력 */
select * from EMP
where DEPTNO = 30 and (SAL between 1500+1 and 3000-1);
-- where DEPTNO = 30 and (SAL between 1500 and 3000) and SAL != 1500 and SAL !=3000;
-- where DEPTNO = 30 and (SAL >1500 and SAL < 3000);

/* 7. 부서 번호 30번 중 1500~3000 사이(미포함)인 사람을 연봉이 작은 순으로 출력, 연봉이 같은 경우 이름이 빠른 순으로 출력 */
select * from EMP
where DEPTNO = 30 and (SAL between 1500 and 3000) and SAL != 1500 and SAL !=3000
order by SAL asc, ENAME asc;

select * from EMP
where DEPTNO = 30 and (SAL > 1500 and SAL < 3000)
-- order by SAL, ENAME;
order by SAL asc, ENAME asc;

/* 8. 부서 번호 20,30번 중 1500~3000 사이(미포함)인 사람을 연봉이 작은 순으로 출력, 연봉이 같은 경우 이름이 빠른 순으로 출력 */
select * from EMP
where DEPTNO in(20,30) and (SAL > 1500 and SAL < 3000)
-- 같은 컬럼이 =과 or으로 연결되어 있는 경우 in으로 변경 가능
order by SAL asc, ENAME asc;

-- and(논리곱)가 먼저 적용되어서 다른 값이 나옴 
select * from EMP
where DEPTNO = 20 or DEPTNO = 30 and (SAL > 1500 and SAL < 3000)
order by SAL asc, ENAME asc;

/* 9. 부서 번호가 20 또는 30이고 급여가 1500 이상인 직원의 이름과 급여를 급여 오름차순으로 출력하라. */
select ENAME, SAL from EMP
where DEPTNO in(20,30) and SAL >= 1500
order by SAL asc;


-- between 연산자
select * from EMP
where SAL between 2000 and 3000;

select * from EMP
where SAL between 2000 and 3000
and DEPTNO = 20;

select * from EMP
where SAL not between 2000 and 3000; 

/* 2000 초과, 3000 미만 */
select * from EMP
where SAL between 2000 and 3000
and SAL != 2000
and SAL != 3000;


-- like 연산자
select * from EMP
where ENAME like 'S%'; -- 그냥 'S'만 쓰면 = S라는 값을 의미. 대소문자 가려야 함.

select * from EMP
where ENAME like '_L%'; -- _(언더바)는 한 자리의 문자열만 의미

select * from EMP
where ENAME like 'A_L%';

select * from EMP -- %는 원하는 문자열 앞 뒤 모두에 쓸 수 있음.
where ENAME like '%AM%';  -- 이름에 AM이 포함된 직원을 조회

select * from EMP
where ENAME  like '%S%'; -- 이름에 S가 포함된 직원을 조회

select * from EMP
where ENAME not like '%AM%'; -- 이름에 AM이 포함되지 않는 직원을 조회

select * from EMP
where ENAME like '%A%' or ENAME like '%a%'; -- 대소문자 같이 하려면


-- is null 연산자(null은 계산이 안 됨 = 참/거짓을 가릴 수 없음)
select * from EMP
where comm > 400; -- 널도 포함되지 않음

select * from EMP
where MGR is null;

select * from EMP
where COMM is not null; -- 데이터가 null이 아닌 것을 조회


-- 집합 연산자
select * from EMP where DEPTNO = 10
union
select * from EMP where DEPTNO = 20;

select * from EMP where DEPTNO = 10
union all
select * from EMP where DEPTNO = 10; -- union all은 중복 데이터도 모두 출력

select EMPNO from EMP
union all
select SAL from EMP; -- 출력시 컬럼의 타입(숫자)이 같아 합쳐져 출력됨

select EMPNO from EMP
union all
select ENAME from EMP; -- 출력시 컬럼의 타입(숫자, 문자)이 같지 않아 출력되지 않음



/* 교재 130,131쪽 문제 */
-- Q1. EMP 테이블을 사용하여 사원 이름(ENAME)이 S로 끝나는 사원 데이터를 모두 출력
select * from EMP
Where ENAME like '%S';

-- Q2. EMP 테이블을 사용하여 30번 부서에서 근무하느 사원 중 직책이 SALESMAN인 사원인 사원의 번호, 이름, 직책, 급여, 부서 번호를 출력
select EMPNO, ENAME, JOB, SAL, DEPTNO from EMP
where DEPTNO = 30 and JOB = 'SALESMAN';

/* Q3. EMP 테이블을 사용하여 20번, 30번 부서에서 근무하는 사원 중 급여가 2000 초과인 사원을 다음 두 방식의 select문을 사용하여 
사원 번호, 이름, 직책, 급여, 부서 번호를 출력 */
--집합 연산자를 사용하지 않은 방식 
select EMPNO, ENAME, JOB, SAL, DEPTNO from EMP
where DEPTNO in(20,30) and SAL > 2000;
-- 집합 연산자를 사용한 방식
select EMPNO, ENAME, JOB, SAL, DEPTNO from EMP 
where DEPTNO = 20 and SAL > 2000
union
select EMPNO, ENAME, JOB, SAL, DEPTNO from EMP 
where DEPTNO = 30 and SAL > 2000;

-- Q4. not between A and B 연산자를 쓰지 않고 급여 열이 2000 이상 3000 이하 범위 의외의 값을 가진 데이터만 출력
select * from EMP
where not (SAL >= 2000 and SAL <= 3000); -- 급여가 2000 이상 3000 이하가 아닌 값

SELECT * FROM EMP
WHERE SAL < 2000 OR SAL > 3000;

-- Q5. 사원 이름에 E가 포함가 30번 부서의 사원 중 급여가 1000~2000 사이가 아닌 사원 이름, 사원 번호, 급여, 부서 번호를 출력
-- 해석: 이름, 사원번호, 급여, 부서를 입력하기
-- 해석: 이름에 E 포함 ,부서는 30, 급여 1000~2000가 아닌
select ENAME, EMPNO, SAL, DEPTNO from EMP
Where DEPTNO = 30 
    and ENAME like '%E%' 
    and (SAL not between 1000 and 2000); 


/* Q6. 추가 수당이 없고 상급자가 있고 직책이 MANAGER, CLERK인 사원 중에서 
사원 이름의 두번째 글짜가 L이 아닌 사원의 정보를 출력 */
-- 해석: 추가수당 null, MGR이 null이 아님, 직책은 M, C이고, 이름에 두번째 글짜가 L이 아님
select * from EMP
where COMM is null 
    and MGR is not null
    and JOB in('MANAGER', 'CLERK')
    and ENAME not like '_L%';
    
    
/* 챗지피티로 논리회로 해석 문제 연습 */
/* 연습 문제 1
조건: 부서 번호(DEPTNO)가 10도 아니고 30도 아닌 직원들을 조회하라.
BETWEEN, IN 사용 금지 */
SELECT * FROM EMP
WHERE DEPTNO != 10 and DEPTNO != 30;

/* 연습 문제 2
조건: 이름(ENAME)이 'SMITH' 또는 'ALLEN'이 아닌 직원들을 조회하라. 
NOT IN 사용 금지 */
select * from EMP
Where ENAME != 'SMITH' and ENAME != 'ALLEN';
-- '또는'을 무조건 or로 해석하지 말기! 

/* 연습 문제 3
조건: 급여(SAL)가 1000 이상 1500 이하 범위를 제외한 즉, 1000 미만 또는 1500 초과인 직원들을 조회하라.
금지 사항: BETWEEN, NOT BETWEEN */
select * from EMP
where not(SAL >=1000 and SAL <= 1500);  
-- 지피티가 쓴 더 간단한 버전
SELECT * FROM EMP
WHERE SAL < 1000 OR SAL > 1500;

/*  연습 문제 4
조건: 직업(JOB)이 'MANAGER'이거나 부서번호(DEPTNO)가 20인 직원 중에서, 급여(SAL)가 3000 이상인 직원만 조회하라. */
select * from EMP
where (JOB = 'MANAGER' or DEPTNO = 20) and SAL >= 3000;

/* 연습 문제 5
조건: 커미션(COMM)이 NULL이 아닌 직원들만 조회하라. */
select * from EMP
where COMM is not null;

/* 연습 문제 6
조건: 직원 이름(ENAME)이 'JONES'인 직원의 급여(SAL)가 2000 이상 3000 이하 범위에 해당하는 직원만 조회하되,
부서번호(DEPTNO)가 30이 아닌 직원만 선택하라. */
select * from EMP
where ENAME = 'JONES' and SAL between 2000 and 3000
and not DEPTNO = 30;

/* 연습 문제 7
조건: 급여(SAL)가 1000 이상이고 부서번호(DEPTNO)가 20 이하인 직원 중에서,
직업(JOB)이 'CLERK'이거나 'SALESMAN'인 직원만 조회하라. */
select * from EMP
where SAL >= 1000 
    and DEPTNO <= 20 
    and JOB in('CLERK', 'SALESMAN');
    
/* 연습 문제 8
조건: 직원 이름(ENAME)이 'KING'이 아니고, 직업(JOB)이 'PRESIDENT'인 직원이 아닌 직원들 중에서,
부서번호(DEPTNO)가 10 또는 30인 직원만 조회하라. 단, IN 연산자는 사용하지 마세요. */
select * from EMP
where not (ENAME = 'KING' and JOB = 'PRESIDENT')
    and (DEPTNO = 10 or DEPTNO = 30);



/* 오라클 함수 */
/* upper(모두 대문자로), lower(모두 소문자로), initcap(첫글자만 대문자, 나머지는 소문자) 함수 */
select ENAME, upper(ENAME), lower(ENAME), initcap(ENAME) from EMP;

-- upper와 lower는 검색 기능에 사용됨 
select ENAME from EMP
where lower(ENAME) like lower('%aM%');

select upper('abc'), lower('aBc') from dual;


/* length 함수 */
select ENAME, length(ENAME) from EMP;

-- 글자수가 5개인 이름을 출력
select * from EMP
where Length(ENAME)=5;

-- 글자수가 5개 이상인 이름을 출력
select * from EMP
where Length(ENAME) >= 5;

/* lengthB 함수 */ 
-- 문자열 데이터를 바이트 수로 반환
select length('한글'), lengthb('한글') from dual;


/* 챗지피티를 이용한 논리회로 연습 문제 2 */
/* 문제 1
조건: 급여(SAL)가 2000 이상 3000 이하 범위를 제외한 직원들을 조회하라.
제약: NOT BETWEEN 사용 금지 */
select * from EMP
where SAL < 2000 or SAL > 3000;

select * from EMP
Where not(SAL >= 2000 and SAL <=3000);

/* 문제 2
조건 : 급여(SAL)가 2000 이상 3000 이하 범위를 제외한 직원들 중, 부서 번호(DEPTNO)가 10 또는 20인 직원만 조회하라.
제약: BETWEEN, NOT BETWEEN을 사용하지 말고 작성할 것.*/
select * from EMP
where (sal > 2000 and sal < 3000) 
    and (DEPTNO = 10 or DEPTNO = 20); 

/* 문제 5
조건 : 급여(SAL)가 1000 이상 3000 이하 범위에 해당하지 않는 직원 중에서, 직책(JOB)이 'CLERK' 또는 'SALESMAN'인 직원들을 조회하라.
제약: `BETWEEN`, `NOT BETWEEN`, `IN` 사용 금지 */
select * from EMP
where (SAL > 1000 or SAL < 3000)
and (JOB = 'CLERK' or JOB = 'SALESMAN');



/* 250515(목) */
-- 복습 
-- 부서 10번을 사원번호 내림차순으로 정렬하여 출력
select * from EMP where DEPTNO = 10
order by EMPNO desc;
-- 부서 20번을 사원번호 오름차순으로 정렬하여 출력
select * from EMP where DEPTNO = 20 
order by EMPNO asc;
-- union all 할 때 order by를 여러번쓸수없음. 내림차순 오름차순이 다르면 할 수 없음


/* SUBSTR 함수 */
select JOB, substr(JOB,1,2), substr(JOB,3,2), substr(JOB,5) from EMP;

-- 사원 이름을 두번째부터 세글자만 출력
select ENAME, substr(ENAME, 2, 3) from EMP;

select substr(ename, 20, 300) from EMP; -- 실제 문자 길이보다 넘어가면 null

-- 음수가 들어가면 오른쪽부터 계산
select JOB, substr(JOB, -3, 2) from EMP;
-- 이름의 마지막 3글자만 출력하기
select ENAME, substr(ENAME, -3) from EMP;

-- length(글자수)(값이 숫자로 변환)와 같이 사용 가능
select JOB,
    substr(JOB, -length(JOB)), -- 음수로 시작하여 JOB의 시작부분으로 지정 가능
    substr(JOB, -length(JOB), 2),
    substr(JOB, -3)
from EMP;

/* REPLACE 함수 */
select '010-1234-5678' as REPLACE_BEFORE,  
        replace('010-1234-5678', '-', ' ') as REPLACE_1,
        replace('010-1234-5678', '-') as REPLACE_2
from DUAL;

-- 대문자 A를 '-'모두 교체
select ENAME, replace(ENAME, 'A', '-') as REPLACE
from EMP;

select '구글' as REPLACE_BEFORE,  
        replace('구글', '구글', 'Google') as REPLACE_1
from DUAL;


/* LPAD, RPAD 함수 */
select ENAME,
    lpad(ENAME, 10, '#') as LPAD_1,
    rpad(ENAME, 10, '#') as rPAD_2,
    lpad(ENAME, 10) as LPAD_2,
    rpad(ENAME, 10) as rPAD_2
from EMP;

select rpad('000101-', 14, '*'),
        rpad('010-1234-', 13, '*')
from dual;

-- 문제 1 : ENAME의 앞 두글자만 출력
select ENAME, lpad(ENAME, 2) from EMP;
select ENAME, substr(ENAME, 1,2) from EMP;

-- 문제 2 
-- 앞의 두글자만 원본을 출력하고 나머지는 4개의 *로 표시) 
select ENAME, rpad(substr(ENAME, -length(ENAME),2), 6, '*') from EMP;
select ENAME, rpad(substr(ENAME, 1, 2), 6, '*') from EMP;

-- 문제 3 
-- 사원 이름 두 글자만 보이고 나머지는 *로 , 단 원래 이름 만큼 길이 표시 
select ENAME, rpad(substr(ENAME, -length(ENAME), 2), Length(ENAME), '*') from EMP;
select ENAME, rpad(substr(ENAME, 1, 2), Length(ENAME), '*') from EMP;

-- 심화 문제 1 
-- 이름을 총 20자 중 가운데 정렬
--(내가 막힌 것)
select JOB,
        rpad(lpad(JOB, 20 - length(JOB)), 20) as 가운데정렬
from EMP;
--(챗지피티 답)
SELECT JOB,
       RPAD(LPAD(JOB, 20/2 + LENGTH(JOB)/2), 20) AS 가운데정렬
FROM EMP;

/* CONCAT 함수 */
--  2개의 문자열 데이터를 하나로 연결
select concat(EMPNO, ENAME) from EMP;

select 'ab' || 'cd' from DUAL;
select EMPNO || ENAME from EMP;
select EMPNO || ' : ' || ENAME from EMP;

/* TRIM 함수 */
-- 앞 뒤의 공백을 자른다
select '   ab c   ', trim('   ab c   ') from dual;

/* ROUND 함수 (반올림)*/
select round(14.46), -- 숫자 뒤에 아무것도 입력 안 하면 자동으로 0의 자리에서 반올림
    round(14.46, 0), -- 14 / 0의 자리에서 반올림
    round(14.46, 1), -- 14.5 / 소수점 1의 자리에서 반올림
    round(14.46, -1) -- 10 / 1의 자리에서 반올림
from dual;
    
/* TRUNC 함수(버림) */
select trunc(14.46), -- 숫자 뒤에 아무것도 입력 안 하면 자동으로 0의 자리에서 버림
    trunc(14.46, 0), -- 14
    trunc(14.46, 1), -- 14.4 / 소수점 1의 자리에서 버림
    trunc(14.46, -1) -- 14.4 / 양수 1의 자리에서 버림
from dual;
    
/* CEIL, FLOOR 함수 */
-- 올림, 내림 함수(반올림, 반내림과 다름)
select ceil(3.14), -- 4(1의 자리에서 올림)
    floor(3.14), -- 3(1의 자리에서 내림)
    ceil(-3.14), 
    floor(-3.14)
from dual;

/* MOD 함수 */
-- 나머지를 구함
select 7 / 3 from dual;
select 7 / 0 from dual; -- 0으로 나누면 무한대로 연산하게 됨

select mod(7, 3), mod(8, 3), mod(9, 3) from dual; -- 나머지는 몫을 넘지 못함

/* 날짜 함수 */
-- SYSDATE(OS의 현재 날짜)
select sysdate as now from dual;

/* 자료형 변환 함수 */
select EMPNO, EMPNO + '1000' from EMP; -- 문자지만 숫자로 이루어진 문자라면 연산 가능
select EMPNO, EMPNO + 'a' from EMP; -- 숫자 + 문자는 에러남
select 'a' + 'b' from dual; -- 연산자는 숫자에만 적용됨. 문자형은 에러남.
select 'a' || 'b' from dual; -- ||(파이프)로 문자 합치기 

-- TO_CHAR 함수 : 날짜,숫자 데이터를 문자열 데이터로 전환
select to_char(sysdate, 'yyyy/mm/dd hh24:mi:ss') as 현재날짜시간
from dual;

select to_char(sysdate, 'yyyy"년" mm"월" dd"일" hh24"시" mi"분" ss"초"') as 현재날짜시간
from dual;

select to_char(HIREDATE, 'yyyy"년" mm"월" dd"일"') as 입사날짜 from EMP;

select to_char(SAL, '$999,999') from EMP; 

-- TO_NUMBER 함수 : 숫자 데이터로 전환
select to_number('1,300', '999,999') - to_number('1,500', '999,999') from dual; 

-- TO_NUMBER 함수 : 문자열 데이터를 날짜 데이터로 전환
select to_date('20250515', 'yyyy-mm-dd') from dual;
select to_date('19990528', 'yyyy-mm-dd') - to_date(sysdate, 'yyyy-mm-dd') from dual;

select * from EMP
where HIREDATE > to_date('19810601', 'yyyy-mm-dd');

select * from EMP
where HIREDATE > '81-06-01';

/* NULL 처리 함수 */
-- NVL 함수
-- 첫번째 입력 데이터가 null이 아니면 그 데이터를 그대로 사용하고, null이면 두번째 입력 데이터로 변경함
-- 계산이 가능해짐
select SAL*12 + COMM from EMP; -- null이 그대로 출력
select (SAL*12 + nvl(COMM, 0)) as 연봉 from EMP;

-- NVL2 함수 : 널이 아닌 값과 널인 값을 각각 지정 가능함
select sal, nvl2(comm, 'o', 'X') from emp;

/* 복습 */
-- 사원 이름을 총 20자 중 가운데 정렬
select ENAME, 
    (rpad(lpad(ENAME, 20/2 + length(ENAME)/2), 20)) as NAME
-- lpad로 사원이름 왼쪽 10칸 먼저 차지 + 사원이름의 길이의 반 만큼 차지 + 사원 이름
-- 이것을 오른쪽 정렬로 
from EMP;