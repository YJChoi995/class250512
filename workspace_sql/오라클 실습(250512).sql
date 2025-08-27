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


/* 250516 */
-- 복습 문제: 각 사원의 연봉을 출력
select ENAME, SAL*12 + NVL(COMM,0) as total_pay 
from EMP;

/* DECODE 함수 */
-- 기준 데이터와 비교하여 다른 결괏값을 출력
select EMPNO, ENAME, JOB, SAL,
    decode(JOB,
            'MANAGER', SAL*1.1,
            'SALESMAN', SAL*1.05,
            'ANALYST', SAL,
            SAL*1.03) as UPSAL
from EMP;

/* CASE 함수 */
-- 비교 데이터 필요 X, 각 조건식이 참/거짓인지만 검사
select EMPNO, ENAME, JOB, SAL, 
    case JOB when 'MANAGER' then SAL*1.1
            when 'SALESMAN' then SAL*1.05
            when 'ANALYST' then SAL
            else SAL*1.03
    end as UPSAL
from EMP;

-- nvl 사용하지 않고 decode, case로 nvl이랑 동일한 결과 출력하기
select nvl(COMM, -1) as nvl,
        decode(COMM, 
                null,-1,
                COMM) as decode,
        case COMM when null then -1
            else COMM
        end as case
from EMP;


select EMPNO, ENAME, COMM,
    case when COMM is null then '해당 사항 없음'
            when COMM = 0 then '수당 없음'
            when COMM > 0 then '수당 : ' || COMM
    end as COMM_TEXT
from EMP;


/* 교재 179, 180쪽 문제 */
/* Q1. EMPNO 열에는 EMP 테이블에서 사원 이름이 다섯 글자 이상이며 여섯 글자 미만인 사원 정보를 출력
        MASKING_EMPNO 열에는 사원 번호 앞 두 자리 외 뒷자리를 * 기호로 출력
        MASKING_ENAME 열에는 사원 이름 첫 글자만 보여주고 나머지 글자 수 만큼 * 기호로 출력 */
-- 출력 열: EMPNO, MASKING_EMPNO, ENAME, MASKING_ENAME
select EMPNO,
        rpad(substr(EMPNO,1, 2), 4, '*') as MASKING_EMPNO,
        ENAME,
        rpad(substr(ENAME, 1, 1), length(ENAME), '*') as MASKING_ENAME
from EMP
where length(ENAME) >= 5 and length(ENAME) < 6;

/* Q2. EMP 테이블에서 사원의 월 평균 근무일 수는 21.5일이다. 하루 근무 시간을 8시간으로 보았을 때 
        사원의 하루 급여(DAY_PAY)와 시급(TIME_PAY)을 계산하여 결과를 출력.
        단, 하루 급여는 소수 셋째 자리에서 버리고, 시급은 소수 둘째 자리에서 반올림하라. */
-- 출력 열: EMPNO, ENAME, SAL, DAY_PAY, TIME_PAY 
select EMPNO, ENAME, SAL,
    trunc(sal/21.5, 2) as DAY_PAY,
    round(sal/21.5/8, 1) as TIME_PAY 
from EMP;

/* Q3. EMP 테이블에서 사원은 입사일을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 된다.
    사원이 정직원이 되는 날짜(R_JOB)을 yyyy-mm-dd 형식으로 출력하라.
    단, 추가 수당(COMM)이 없는 사원의 추가수당은 N/A로 출력, */
-- 출력 열: EMPNO, ENAME, HIREDATE, R_JOB, COMM
select EMPNO, ENAME, HIREDATE,
    to_char(add_months(HIREDATE, 3), 'yyyy-mm-dd') as R_JOB,
    -- NVL(COMM, 'N/A') as COMM -- 문자열, 숫자열이 같이 쓰여서 실행안됐음 
    NVL(to_char(COMM), 'N/A') as COMM 
from EMP;

/* Q4. EMP 테이블의 모든 사원을 대상으로 직속 상관의 사원 번호(MGR)을 다음과 같은 조건을 기준으로
    변환해서 CHG_MGR열에 출력하라.
    조건 : 직속상관의 사원 번호가 없을 때 : 0000
            직속상관의 사원 번호 앞 두 자리가 75일 때 : 5555
            직속상관의 사원 번호 앞 두 자리가 76일 때 : 6666
            직속상관의 사원 번호 앞 두 자리가 77일 때 : 7777
            직속상관의 사원 번호 앞 두 자리가 78일 때 : 8888
            그 외의 직속상관 사원의 번호일 때 : 본래 직속상관의 사원 번호를 그대로 출력 */
-- 출력 열 : EMPNO, ENAME, MGR, CHG_MGR
-- 내가 만든거
select EMPNO, ENAME, MGR,
    case 
        when MGR is null then '0000'
        when substr(to_CHAR(MGR),1,2) = '75' then '5555'
        when substr(to_CHAR(MGR),1,2) = '76' then '6666'
        when substr(to_CHAR(MGR),1,2) = '77' then '7777'
        when substr(to_CHAR(MGR),1,2) = '78' then '8888'
        else to_char(MGR)
    end as CHG_MGR
from EMP;    

-- 재은 씨 답
select EMPNO, ENAME, MGR,
    case 
        when MGR is null then '0000'
        when MGR like '75%' then '5555'
        when MGR like '76%' then '6666'
        when MGR like '77%' then '7777'
        when MGR like '78%' then '8888'
        else to_char(MGR)
    end as CHG_MGR
from EMP;  

-- 선생님 답 1
select EMPNO, ENAME, MGR,
    case 
        when MGR is null then '0000'
        when MGR is not null then
                                case substr(MGR, 1, 2)
                                    when '75' then '5555'
                                    when '76' then '6666'
                                    when '77' then '7777'
                                    when '78' then '8888'
                                    else to_char(MGR)
                                end
    end as CHG_MGR
from EMP;    

-- 선생님 답 2
select EMPNO, ENAME, MGR,
    case substr(MGR, 1, 2)
        when '75' then '5555'
        when '76' then '6666'
        when '77' then '7777'
        when '78' then '8888'
        else to_char(nvl(MGR, '0000'))
    end as CHG_MGR
from EMP;    

-- 선생님 답 3
select EMPNO, ENAME, MGR,
    case
        when MGR is null then '0000'
        when substr(MGR, 2, 1) in('5','6','7','8')
            then rpad(substr(MGR, 2, 1), length(MGR), substr(MGR, 2, 1)) 
        else '' || MGR
    end as CHG_MGR
from EMP;    


/* 다중행 함수 */
-- where에서 쓰기 곤란함.
-- SUM 함수
select SUM(SAL) from EMP;
select ENAME, SUM(SAL) from EMP; -- 엑셀로 치면 여러 줄과 셀 병합 셀을 같이 출력하였기에 불가
select sum(COMM) from EMP; -- null은 알아서 무시됨

-- COUNT 함수
select count(*) from EMP; -- 몇 줄(행)이 있는가
select count(*), sum(SAL) from EMP; -- count와 sum 같이 쓸수 있음
select count(SAL), count(COMM) from EMP; 
-- null은 제외하고 카운팅. 어떤 행에 null이 있는지 모르기에 *를 많이 사용

-- MAX, MIN 함수
select max(SAL), min(SAL), min(HIREDATE), min(COMM) from EMP; -- 날짜도 가능. null은 알아서 제외

-- 문제 : 이름에 A가 있는 사람은 몇명인가
select count(ENAME) from EMP
where ENAME like '%A%';

-- AVG 함수 : 평균값
select avg(SAL) from EMP;
-- 문제 : 평균보다 높게 받는 사람 출력
select * from EMP
where SAL > avg(SAL); -- 다중행 함수(집계 함수)는  where에서 사용할 수 없다

/* GROUP BY절 */
-- distint(중복 제거) 대신 group by를 더 활용함
select avg(SAL), DEPTNO from EMP
group by DEPTNO;

select JOB from EMP
group by JOB;

select DEPTNO, JOB, count(*)
from EMP
group by DEPTNO, JOB
order by DEPTNO, JOB;

select JOB from EMP 
where DEPTNO = 10 -- group by와 where 함께 사용가능함
group by JOB;

-- HAVING 절
select JOB, DEPTNO from EMP 
group by DEPTNO, JOB
    having deptno = 10;
    
select DEPTNO, JOB, avg(SAL) from EMP 
group by DEPTNO, JOB
    having avg(SAL) >= 2000;
    
    
    
/* 정리 (실행 순서) */
/* 5 */select JOB, count(*) as CNT 
/* 1 */ from EMP 
/* 2 */ where SAL > 1000 
/* 3 */ group by JOB
   /* 4 */ having count(*) >= 3
/* 6 */ order by CNT desc;

 
/* 교재 200쪽 문제 */
/* Q1. EMP 테이블에서 부서 번호, 평균 급여(AVG_SAL), 최고 급여(MAX_EMP), 최저 급여(MIN_SAL), 사원 수(CNT)를 출력
단, 평균 급여를 출력할 때 소수는 제외하고 부서 번호별로 출력 */
-- 출력 : DEPTNO, AVG_SAL, MAX_SAL, MIN_SAL, CNT
select DEPTNO, 
        trunc(avg(SAL), 0) as AVG_SAL,
        max(SAL) as MAX_SAL,
        min(SAL) as MIN_SAL,
        count(*) as CNT
from EMP
group by DEPTNO
order by DEPTNO asc;

/* Q2. 같은 직책(JOB)에 종사하는 사원이 3명 이상인 직책과 인원수를 출력하라 */
-- 출력 : JOB, COUNT(*)
select JOB, count(*)
from EMP
group by JOB
    having count(JOB) >= 3;

/* Q3. 사원의 입사 연도(HIRE_YEAR)를 기준으로 부서별로 몇 명씩 입사했는지 출력하라 */
-- 출력: HIRE_YEAR, DEPTNO, CNT
select to_char(HIREDATE,'yyyy') as HIRE_DATE,
        DEPTNO
from EMP
group by HIREDATE, DEPTNO
order by HIREDATE asc;

/* Q4. 추가 수당(COMM)을 받는 사원 수와 받지 않는 사원 수를 출력하라 */
-- 출력: EXISXT_XOMM, CNT
select nvl2(COMM, 'X', 'O') as EXIST_COMM,
        count(*)
from EMP
group by nvl2(COMM, 'X', 'O');



/* 250519(월) 6일차 */
/* JOIN */
select * from DEPT;

select * from EMP, DEPT
order by EMPNO;

select * from EMP, DEPT
where EMP.DEPTNO = DEPT.DEPTNO
order by EMPNO asc;

-- 테이블 별칭 설정
select * from EMP E, DEPT D
where E.DEPTNO = D.DEPTNO
order by EMPNO asc;

select ENAME, DEPTNO -- DEPTNO가 E테이블과 D테이블에 모두 있는데 어디에서 가져올지
from EMP E, DEPT D   -- 지정하지 않아 에러 뜸.
where E.DEPTNO = D.DEPTNO; 

select E. ENAME, E.DEPTNO
from EMP E, DEPT D
where E.DEPTNO = D.DEPTNO;

/* 등가 조인 */
-- where절에 조건식 추가하여 출력 범위 설정하기
select E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC
from EMP E, DEPT D
where E.DEPTNO = D.DEPTNO   
    and SAL >= 3000;

/* 비등가 조인 */    
select * from SALGRADE;

select * from EMP E, SALGRADE S
where E.SAL between S.LOSAL and S.HISAL;
-- EMP테이블의 SAL이 SALGRADE테이블의 LOSAL보다 크거나 같고 HISAL보다 작거나 같다

/* 자제 조인 */
select E1.EMPNO, E1.ENAME, E1.MGR,
        E2.EMPNO as MGR_EMPNO,
        E2.ENAME as MGR_ENAME
from EMP E1, EMP E2
where E1.MGR = E2.EMPNO;
-- king은 MGR이 null이기 때문에 출력되지 않음

/* 외부 조인 */
-- 왼쪽 외부 조인(left outer join) : where Table1.Col1 = Table2.Co2(+)
-- 오른쪽 외부 조인(right outer join) : where Table1.Col1(+) = Table2.Co2

select E1.EMPNO, E1.ENAME, E1.MGR,
        E2.EMPNO as MGR_EMPNO,
        E2.ENAME as MGR_ENAME
from EMP E1, EMP E2
where E1.MGR = E2.EMPNO(+)
order by E1.EMPNO;

select E1.EMPNO, E1.ENAME, E1.MGR,
        E2.EMPNO as MGR_EMPNO,
        E2.ENAME as MGR_ENAME
from EMP E1, EMP E2
where E1.MGR(+) = E2.EMPNO
order by E1.EMPNO;

/* JOIN USING */
select E.EMPNO, E.ENAME, E.JOB, E.HIREDATE, E.SAL, E.COMM,
        DEPTNO, D.DNAME, D.LOC
from EMP E join DEPT D using (DEPTNO)
where SAL >= 3000
order by DEPTNO, E.EMPNO;

/* JOIN ON */
  select E.EMPNO, E.ENAME, E.JOB, E.HIREDATE, E.SAL, E.COMM,
         E.DEPTNO, 
         D.DNAME, D.LOC
    from EMP E join DEPT D on (E.DEPTNO = D.DEPTNO)
   where SAL <= 3000
order by E.DEPTNO, EMPNO;

/* OUTER JOIN */
select *
  from EMP E1 left outer join EMP E2 on(E1.MGR = E2.EMPNO);
-- E1.MGR = E2.EMPNO(+)와 같음 

select *
  from EMP E1 right outer join EMP E2 on(E1.MGR = E2.EMPNO);

select *
  from EMP E1 full outer join EMP E2 on(E1.MGR = E2.EMPNO);


/* 교재 되새김 문제(p.226,227) */
/* Q1. 급여(SAL)가 2000을 초과한 사원의 부서 정보, 사원 정보를 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라)
출력 : DEPTNO, DNAME, EMPNO, ENAME, SAL */
-- SQL-99 이전 방식
select D.DEPTNO, D.DNAME, E.EMPNO, E.ENAME, E.SAL
from EMP E, DEPT D
where (E.DEPTNO = D.DEPTNO) and SAL > 2000
order by D.DEPTNO asc, D.DNAME asc;

-- SQL-99 방식
  select D.DEPTNO, D.DNAME, E.EMPNO, E.ENAME, E.SAL
    from EMP E join DEPT D on(E.DEPTNO = D.DEPTNO) 
   where SAL > 2000
order by D.DEPTNO asc, D.DNAME asc;

/* Q2. 부서별 평균 급여, 최대 급여, 최소 급여, 사원 수를 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라) 
출력: DEPTNO, DNAME, AVG_SAL, MAX_SAL, MIN_SAL, CNT */
-- SQL-99 이전 방식
  select D.DEPTNO, D.DNAME,
         trunc(avg(E.SAL),0) as AVG_SAL,
         max(E.SAL) as MAX_SAL,
         min(E.SAL) as MIN_SAL,
         count(*)
    from EMP E, DEPT D
   where E.DEPTNO = D.DEPTNO
group by D.DEPTNO, D.DNAME;

-- SQL-99 방식
  select D.DEPTNO, D.DNAME,
         floor(avg(E.SAL)) as AVG_SAL,
         max(E.SAL) as MAX_SAL,
         min(E.SAL) as MIN_SAL,
         count(*)
    from EMP E join DEPT D on(E.DEPTNO = D.DEPTNO)
group by D.DEPTNO, D.DNAME;

/* Q3. 모든 부서 정보와 사원 정보를 다음과 같이 부서 번호, 사원 이름순으로 정렬하여 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라) 
출력 : DEPTNO, DNAME, EMPNO, ENAME, JOB, SAL */
-- SQL-99 이전 방식
  select D.DEPTNO, D.DNAME,
         E.SAL, E.JOB, E.SAL
    from EMP E, DEPT D
   where D.DEPTNO = E.DEPTNO(+)
order by D.DEPTNO, E.ENAME;

-- SQL-99 방식
  select D.DEPTNO, D.DNAME,
         E.SAL, E.JOB, E.SAL
    from DEPT D left outer join EMP E on(D.DEPTNO = E.DEPTNO)
order by D.DEPTNO, E.ENAME;

/* Q4. 모든 부서 정보, 사원 정보, 급여 등급 정보, 각 사원의 직속상관 정보를 부서 번호, 사원 번호 순서로 정렬하여 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라) 
출력 : DEPTNO, DNAME, EMPNO, ENAME, MGR, SAL, DEPTNO_1, LOSAL, HISAL, GRADE, MGR_EMPNO, MGR_ENAME */
-- SQL-99 이전 방식
  select D.DEPTNO, D.DNAME,
         E1.EMPNO, E1.ENAME, E1.MGR, E1.SAL, E1.DEPTNO, 
         S.LOSAL, S.HISAL, S.GRADE, 
         E2.EMPNO as MGR_EMPNO,
         E2.ENAME as MGR_ENAME
    from EMP E1, EMP E2, DEPT D, SALGRADE S
   where E1.MGR = E2.EMPNO(+)
         and E1.DEPTNO(+) = D.DEPTNO
         and E1.SAL between S.LOSAL(+) and S.HISAL(+)
order by D.DEPTNO, E1.EMPNO;

-- SQL-99 방식
  select D.DEPTNO, D.DNAME,
         E1.EMPNO, E1.ENAME, E1.MGR, E1.SAL, E1.DEPTNO as DEPTNO_1, 
         S.LOSAL, S.HISAL, S.GRADE, 
         E2.EMPNO as MGR_EMPNO,
         E2.ENAME as MGR_ENAME
    from DEPT D left outer join EMP E1 on(D.DEPTNO = E1.DEPTNO)
                left outer join EMP E2 on(E1.MGR = E2.DEPTNO)
                left outer join SALGRADE S on(E1.SAL between S.LOSAL and S.HISAL)
order by D.DEPTNO, E1.EMPNO;



/* 250520(화) 7일차 */
/* 복습 퀴즈 */
-- 각 부서별로 급여가 가장 높은 사원, 가장 낮은 사원의 급여 차이를 출력
  select DEPTNO,
         max(SAL),
         min(SAL),
         max(SAL) - min(SAL) as 급여차 
    from EMP
group by DEPTNO
order by DEPTNO asc;

/* 심화 퀴즈 (며칠 전 문제) */
-- JOB을 총 20자 중 가운데 정렬
-- (전체 길이의 반 - 글씨 길이의 반)
-- 일단 왼쪽 채우고, 다음에 오른쪽 채우고
select JOB,
       rpad(lpad(JOB, 20/2 + length(JOB)/2), 20) as 가운데_정렬
  from EMP;
-- 선생님 답 
select JOB,
       lpad(JOB, 20/2 + length(JOB)/2, ' ') as 가운데_정렬,
       rpad(lpad(JOB, 20/2 + length(JOB)/2, ' '), 20, ' ' ) as 가운데_정렬,
       rpad(lpad(JOB, (20+length(JOB))/2, ' '), 20, ' ' ) as 가운데_정렬
  from EMP;

/* 서브쿼리(subquery)*/
select * from EMP
 where SAL > (select SAL from EMP where ENAME = 'JONES');

-- 단일행 서브쿼리 
select * from EMP
 where HIREDATE < (select HIREDATE from EMP
                    where ENAME = 'SCOTT');
-- 전체 사원의 평균 급여보다 적거나 같은 급여를 받는 20번 부서의 사원을 출력
select * from EMP
 where DEPTNO = 20
       and SAL >= (select avg(sal) from EMP);
    
    
/* 다중행 서브쿼리 */ 
-- in 연산자
select * from EMP
 where DEPTNO in(20,30);

-- 부서별 최고 급여과 같은 급여를 받는 사원 정보 출력
select * from EMP
 where SAL in (select max(SAL) from EMP group by DEPTNO);

-- ANY, SOME 연산자
select * from EMP
 where SAL = any(select max(SAL) from EMP group by DEPTNO);

select * from EMP
 where SAL = some(select max(SAL) from EMP group by DEPTNO);

-- ALL 연산자
-- EXISTS 연산자

/* 비교할 열이 여러 개인 다중열 서브쿼리 */
select * from EMP 
 where (DEPTNO, SAL) in (select DEPTNO, max(SAL) from EMP group by DEPTNO);
 
/* FROM절에 사용하는 서브쿼리와 WITH절 */
-- 인라인 뷰 : from절에 사용하는 서브쿼리. 
-- select문으로 일부 데이터를 먼저 추출한 다음, 별칭을 지정하여 사용
select E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC
  from (select * from EMP where DEPTNO = 10) E10,
       DEPT D
 where E10.DEPTNO = D.DEPTNO;
 
-- JOB별로 3명 이상 있는 부서를 고르시오
select * 
from (select JOB, count(*) CNT
      from EMP
      group by JOB
) 
where CNT >= 3;


 /* 책에 안 나오는 내용 */
select ROWNUM, EMP.*
  from EMP;
 
select * 
from (
      select ROWNUM RN, EMP.*
      from EMP
)
where RN > 3 and RN < 6;

select *
from(
     select ROWNUM RN, E.*
     from (select EMP.* from EMP
           order by SAL desc) E
)
where RN >=2 and RN <= 4;


-- WITH절 사용하기
with 
E10 as (select * from EMP where DEPTNO =10),
D   as (select * from DEPT)
select E10.EMPNO, E10.ENAME, E10.DEPTNO, D.DNAME, D.LOC
  from E10, D
 where E10.DEPTNO = D.DEPTNO;
 
/* SELECT절에 사용하는 서브쿼리 */
select EMPNO, ENAME, JOB, SAL, 
       (select GRADE
          from SALGRADE
         where E.SAL between LOSAL and HISAL) as SALGRADE,
       DEPTNO, 
       (select DNAME
          from DEPT
         where E.DEPTNO = DEPT.DEPTNO) as DNAME
from EMP E;


/* 교재 되새김 문제(p.249) */
/* Q1. 전체 사원 중 ALLEN과 같은 직책(JOB)인 사원의 사원 정보, 부서 정보를 출력
출력 : JOB, EMPNO, ENAME, SAL, DEPTNO, DNAME */
  select E.JOB, E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME
    from EMP E, DEPT D
   where E.DEPTNO = D.DEPTNO
         and E.JOB = (select JOB from EMP where ENAME = 'ALLEN')
order by E.SAL desc, E.ENAME asc;

/* Q2. 전체 사원의 평균 급여(SAL)보다 많이 받는 사원의 사원 정보, 부서 정보, 급여 등급 정보를 출력
(단, 출력할 때 급여가 많은 순으로 정렬하되 같다면 사원 번호를 기준으로 오름차순으로 정렬) 
출력 : EMPNO, ENAME, DNAME, HIREDATE, LOC, SAL, GRADE */
-- 풀이
-- 1. 전체 사원 평균 급여 확보
-- 2. 평균 급여 보다 초과하는 사람들 출력
-- 3. 정렬은 급여 내림차순, 사원 번호 오름차순
  select E.EMPNO, E.ENAME,
         (select D.DNAME from DEPT D where D.DEPTNO = E.DEPTNO) as DNAME,
         E.HIREDATE,
         (select D.LOC from DEPT D where D.DEPTNO = E.DEPTNO) as LOC,
         E.SAL,
         (select S.GRADE from SALGRADE S 
          where E.SAL between S.LOSAL and S.HISAL) as GRADE
    from EMP E
   where E.SAL > (select avg(SAL) from EMP)
order by E.SAL desc, E.EMPNO asc;

/* Q3. 10번 부서에서 근무하는 사원 중 30번 부서에 없는 직책인 사원의 사원 정보, 부서 정보를 출력
출력 : EMPNO, ENAME, JOB, DEPTNO, DNAME, LOC */
select E.EMPNO, E.ENAME, E.JOB, D.DEPTNO, D.DNAME, D.LOC
  from EMP E, DEPT D
 where E.DEPTNO = D.DEPTNO
       and E.DEPTNO = 10
       and E.JOB not in(select JOB from EMP where DEPTNO = 30);

/* Q4. 직책이 SALESMAN인 사람의 최고 급여보다 많이 받는 사원의 사원 정보, 급여 등급 정보를 출력
(사원 번호 기준 오름차순으로 정렬)
출력 : EMPNO, ENAME, SAL, GRADE */
-- 다중행 함수를 사용하는 방법
select E.EMPNO, E.ENAME, E.SAL, S.GRADE
  from EMP E, SALGRADE S
 where (E.SAL between S.LOSAL and S.HISAL)
       and E.SAL > ( select max(SAL) 
                    from (select SAL from EMP where JOB = 'SALESMAN') )
order by E.EMPNO asc;

-- 다중행 함수를 사용하지 않는 방법
select E.EMPNO, E.ENAME, E.SAL, S.GRADE
  from EMP E, SALGRADE S
 where (E.SAL between S.LOSAL and S.HISAL)
       and E.SAL > all ( select SAL from EMP where JOB = 'SALESMAN' )
order by E.EMPNO asc;



/* 250521(수) 8일차 */
/* 복습 문제 */
-- Q1. COMM이 null인 사원을 급여 오름차순으로 정렬
  select * from EMP
   where COMM is null
order by SAL asc;

/* Q2. 급여 등급 별 사원 수를 등급 오름차순으로 정렬
단, 모든 등급을 표시한다 */
  select S.GRADE, count(*)
    from EMP E, SALGRADE S
   where E.SAL between S.LOSAL and S.HISAL
group by S.GRADE
order by S.GRADE asc;

/* Q3. 이름, 급여, 급여 등급, 부서 이름 조회
단, 급여 등급 3 이상만 조회. 급여 등급 내림차순, 급여 등급이 같은 경우 급여 내림차순 */
  select E.ENAME, E.SAL, S.GRADE, D.DNAME 
    from DEPT D left outer join EMP E on (D.DEPTNO = E.DEPTNO)
                left outer join SALGRADE S on (E.SAL between S.LOSAL and S.HISAL)
   where S.GRADE >= 3
order by S.GRADE desc, E.SAL desc;

/* Q4. 부서명이 SALES인 사원 중 급여 등급이 2 또는 3인 사원을 급여 내림차순으로 정렬 */
  select E.*, D.*, S.*
    from DEPT D left outer join EMP E on (D.DEPTNO = E.DEPTNO)
                left outer join SALGRADE S on (E.SAL between S.LOSAL and S.HISAL)
   where D.DNAME = 'SALES'
         and S.GRADE in(2,3)
order by E.SAL desc;

--------------------------------------------------------------------------------
/* DDL */
/* create */
create table EMP_DDL(
    EMPNO number(4),
    ENAME varchar2(10),
    JOB varchar2(9),
    MGR number(4),
    HIREDATE date,
    SAL number(7,2),
    COMM number(7,2),
    DEPTNO number(2)
);

desc EMP_DDL;
select * from EMP_DDL;

-- 기존 테이블 열 구조와 데이터를 그대로 복사해 올 때
create table DEPT_DDL
    as select * from DEPT;
    
desc DEPT_DDL;
select * from DEPT_DDL;

-- 기존 테이블 열 구조와 일부 데이터만 복사해 올 때
create table EMP_DDL_30
    as select * from emp where DEPTNO = 30;
    
desc EMP_DDL_30;
select * from EMP_DDL_30;
    
-- 기존 테이블 열 구조만 복사해 올 때   
create table EMPDEPT_DDL
    as select E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE,
              E.SAL, E.COMM, D.DEPTNO, D.DNAME, D.LOC
    from EMP E, DEPT D
        where 1 <> 1; -- 언제나 거짓이다 : 한 줄도 조회 안되고 컬럼명만 가져옴

desc EMPDEPT_DDL;
select * from EMPDEPT_DDL;


/* ALTER */
create table EMP_ALTER
    as select * from EMP;

-- ADD : 테이블에 열을 추가    
alter table EMP_ALTER
    add HP varchar2(20); -- varchar로 적어도 자동으로 varchar2로 인식

alter table EMP_ALTER
    add AGE varchar2(3) default 1; -- 초기값을 지정할 수 있다
    
-- RENAME : 열 이름 변경
alter table EMP_ALTER
    rename column HP to TEL;
    
-- MODIFY : 열의 자료형을 변경
-- 수정할 때 타입의 크기가 커지는 건 가능하지만 줄어드는건 불가능
alter table EMP_ALTER
    modify EMPNO number(5);

-- DROP : 특정 열을 삭제    
alter table EMP_ALTER
    drop column TEL;    
    
-- table의 이름 변경
rename EMP_ALTER to EMP_RNAME;

-- TRUNCATE : 데이블의 데이터를 삭제
truncate table EMP_RNAME;

select * from EMP_RNAME;

drop table EMP_RNAME;


/* 10장 */
-- INSERT : 테이블에 데이터 추가
create table DEPT_TEMP
    as select * from DEPT;
    
insert into DEPT_TEMP (DEPTNO, DNAME, LOC)
            values (50, 'DATABASE', 'SEOUL');

insert into DEPT_TEMP (DEPTNO, DNAME, LOC)
            values (50, 'DATABASE', 'SEOUL');

insert into DEPT_TEMP
            values (60, 'NEWYORK', 'BUSAN');
            
-- 테이블에 null 데이터 입력하기
insert into DEPT_TEMP (DEPTNO, DNAME, LOC)
            values (70, 'WEB', null);
insert into DEPT_TEMP (DEPTNO, DNAME, LOC)
            values (80, 'MOBILE', ''); -- 오라클 전용 ''을 null 취급
            
insert into DEPT_TEMP (DEPTNO, LOC)
            values (90, 'INCHEON'); -- 데이터를 제외하면 자동으로 null이 입력
            
-- 테이블에 날짜 데이터 입력하기
create table EMP_TEMP
    as select * from EMP where 1 <> 1;

insert into EMP_TEMP(EMPNO, ENAME, HIREDATE)
            values (2111, '이순신', to_date('25/05/21', 'yy/mm/dd'));
            
insert into EMP_TEMP(EMPNO, ENAME, HIREDATE)
            values (3111, '심청이', sysdate);

-- 서브쿼리를 사용하여 한 번에 여러 데이터 추가하기
insert into EMP_TEMP
select * from EMP where DEPTNO = 10;
            
select * from EMP_TEMP;     
select * from DEPT_TEMP;       

/* UPDATE : 테이블에서 데이터를 수정 */
create table DEPT_TEMP2
    as select * from DEPT;

update DEPT_TEMP2
   set LOC = 'SEOUL'; -- loc의 열이 모두 변경됨
   
-- 데이터 일부만 수정
update DEPT_TEMP2
   set DNAME = 'DATEBASE',
       LOC = 'SEOUL2'
where DEPTNO = 40;
-- update, delete의 where를 무조건 select에서 검증하고 사용하기     

select * from DEPT_TEMP2;


create table EMP_TMP
    as select * from EMP;
    
select SAL, SAL*1.03 from EMP_TMP
 where SAL < 1000; 

update EMP_TMP
   set SAL = SAL * 1.03
where SAL < 1000;

select * from EMP_TMP;    

commit;

/* DELETE문 */
create table EMP_TEMP2
    as select * from EMP;
select * from EMP_TEMP2;

/* 데이터 사전 */
select * from dict;
select * from dictionary;

select table_name from USER_TABLES;

/* 인덱스 */
select * from USER_INDEXES;
select * from USER_IND_COLUMNS;

create index IDX_EMP_SAL on EMP(SAL); -- EMP테이블의 SAL 컬럼을 기준으로

/* 오라클의 실행 계획 */
select * from EMP where SAL > 2000;

select /*+ index(E IDX_EMP_SAL) */ -- 강제 hint
* from EMP E 
where SAL >= 2000;

/* VIEW */
create view VW_EMP20
       as (select EMPNO, ENAME, JOB, DEPTNO
           from EMP
           where DEPTNO = 20);
           
/* 시퀀스 */
create sequence SEQ_DEPT
increment by 10 -- 시퀀스에서 생성할 번호의 증갓값(선택)
start with 10 -- 시퀀스에서 생성할 번호의 시작값(선택)
maxvalue 90 -- 생성할 번호의 최댓값 지정(선택)
minvalue 0 -- 생성할 번호의 최솟값 지정(선택)
nocycle -- cycle이면 최댓값에 도달했을 때 시작값에서 다시 시작, no cycle이면 번호 생성을 중단(선택)
cache 2; -- 생성할 번호를 메모리에 미리 할당해 놓을 개수를 지정

create sequence SEQ_DEPT1
start with 10;

select SEQ_DEPT1.nextval
from dual;

select SEQ_DEPT1.currval
from dual;

insert into dept_temp (DEPTNO, DNAME, LOC)
values (SEQ_DEPT1.nextval, '테스트', '천안');
select * from DEPT_TEMP;


/* PRIMARY KEY */
create table TABLE_PK(
       LOGIN_ID varchar2(20) primary key,
       LOGIN_PWD varchar2(20) not null,
       tel varchar2(20) );

-- 이미 존재하는 거에 추가       
insert into TABLE_PK 
values ('ID', 'PW', null);
-- null로 추가
insert into TABLE_PK 
values ('null', 'PW', null);
-- null로 변경 : 업데이트 안되는 것이 정상
update TABLE_PK
set LOGIN_ID = null
where LOGIN_ID = 'ID';
-- 이미 존재하는 것으로 변경
update TABLE_PK
set LOGIN_ID = 'ID2'
where LOGIN_ID = 'ID';

select * from user_indexes;
select * from TABLE_PK;
desc TABLE_PK;

/* FORIEGNKEY */
create table DEPT_FK(
    DEPTNO NUMBER(2) constraint DEPT_FK_PK primary key,
    DNAME varchar2(14),
    LOC varchar2(13)
    );

create table EMP_FK(
    EMPNO number(4) constraint EMPFK_EMPNO_PK primary key,
    ENAME varchar2(10),
    JOB varchar2(9),
    MGR number(4),
    HIREDATE date,
    SAL number(7,2),
    COMM number(7,2),
    DEPTNO number(2) constraint EMPFK_DEPTNO_FK references DEPT_FK (DEPTNO)
);

-- 아직 DEPT_FK에 데이터가 없어서 실패
insert into EMP_FK
values ( 0000, '이름', '직책', 1111, sysdate, 800, 0, 10);

insert into DEPT_FK -- 참조할 테이블에 데이터 넣고 다시 실행
values ( 10, '부서', '위치');
insert into EMP_FK
values ( 0000, '이름', '직책', 1111, sysdate, 800, 0, 10);

select * from EMP_FK;
select * from DEPT_FK;  
desc EMP_FK; 



/* 250523(금) */
/* ERD 연습 */
select * from EMP;
desc EMP;

desc DEPT;


/* 250818(월) */
/* java + DB 연결 연습 */
create table tbl_todo (
     tno number primary key,
     title varchar2(4000) not null,
     dueDate date,
     finished number(1) default 0
);

select * from tbl_todo;

create sequence seq_tbl_todo;

insert into tbl_todo (tno, title, duedate, finished)
values (seq_tbl_todo.nextval, '연습1', null, 0);

insert into tbl_todo (tno, title, duedate, finished)
values (seq_tbl_todo.nextval, '연습2', '2025-08-19', 0);

insert into tbl_todo (tno, title, duedate, finished)
values (seq_tbl_todo.nextval, '연습3', to_date('2025-08-19', 'yyyy-mm-dd'), 0);

commit;


/* 250819(화) */
delete tbl_todo where tno = 21; 

commit;

select * from tbl_todo where tno = 33;

update tbl_todo set title = '바꾸기', 
                    duedate = '2025-01-01',
                    finished = 1
where tno = 33;

commit;


/* 250820(수) */
create table emp2 as select * from emp;

select * from emp2;

delete emp2 where empno = 7934;

commit;

/* 250827(수) */
select * from (
    select rownum rnum, t1.* from (
        select emp2.* from emp2
        order by hiredate desc
    ) t1
) t2
where rnum >= 3 and rnum <= 6;

truncate table emp2;

INSERT INTO emp2 (empno, ename, job, mgr, hiredate, sal, comm, deptno)
SELECT 
    e.empno + lvl AS empno,
    lvl || '_' || e.ename AS ename,
    e.job, 
    e.mgr,
    e.hiredate + lvl AS hiredate,
    e.sal + lvl AS sal,
    e.comm, 
    e.deptno
FROM emp e
JOIN (
    SELECT LEVEL AS lvl 
    FROM dual 
    CONNECT BY LEVEL <= 20
) l
ON 1=1;

commit;
