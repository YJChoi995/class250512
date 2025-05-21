/* 250513 */
/* 교재 130,131쪽 문제 */
-- Q1. EMP 테이블을 사용하여 사원 이름(ENAME)이 S로 끝나는 사원 데이터를 모두 출력
select * from EMP
where ENAME like '%S';

-- Q2. EMP 테이블을 사용하여 30번 부서에서 근무하는 사원 중 직책이 SALESMAN인 사원인 사원의 번호, 이름, 직책, 급여, 부서 번호를 출력
select EMPNO, ENAME, JOB, SAL, DEPTNO from EMP
where DEPTNO = 30 
        and JOB = 'SALESMAN';

/* Q3. EMP 테이블을 사용하여 20번, 30번 부서에서 근무하는 사원 중 급여가 2000 초과인 사원을 다음 두 방식의 select문을 사용하여 
사원 번호, 이름, 직책, 급여, 부서 번호를 출력 */
-- 집합 연산자를 사용하지 않은 방식 
select EMPNO, ENAME, JOB, SAL, DEPTNO from EMP
where (DEPTNO = 20 or DEPTNO = 30)
        and SAL > 2000;

-- 집합 연산자를 사용한 방식
select EMPNO, ENAME, JOB, SAL, DEPTNO from EMP
where DEPTNO in(20, 30) and SAL > 2000;

-- Q4. not between A and B 연산자를 쓰지 않고 급여 열이 2000 이상 3000 이하 범위 의외의 값을 가진 데이터만 출력
select * from EMP
where SAL < 2000 or SAL > 3000;

-- Q5. 사원 이름에 E가 포함되고 30번 부서의 사원 중 급여가 1000~2000 사이가 아닌 사원 이름, 사원 번호, 급여, 부서 번호를 출력
select ENAME, EMPNO, SAL, DEPTNO from EMP
where ENAME like '%E%' 
        and DEPTNO = 30
        and SAL not between 1000 and 2000;        

/* Q6. 추가 수당이 없고 상급자가 있고 직책이 MANAGER, CLERK인 사원 중에서 
사원 이름의 두번째 글짜가 L이 아닌 사원의 정보를 출력 */
select * from EMP
where COMM is null
        and MGR is not null
        and JOB in('MANAGER', 'CLERK')
        and ENAME not like '_L%';
        

/* 챗지피티로 논리회로 해석 문제 연습 */
/* 연습 문제 1
조건: 부서 번호(DEPTNO)가 10도 아니고 30도 아닌 직원들을 조회하라.
BETWEEN, IN 사용 금지 */
select * from EMP
where DEPTNO != 10 and DEPTNO != 30; 

/* 연습 문제 2
조건: 이름(ENAME)이 'SMITH' 또는 'ALLEN'이 아닌 직원들을 조회하라. 
NOT IN 사용 금지 */
select * from EMP
where ENAME != 'SMITH' and ENAME != 'ALLEN';

/* 연습 문제 3
조건: 급여(SAL)가 1000 이상 1500 이하 범위를 제외한 직원들을 조회하라.
금지 사항: BETWEEN, NOT BETWEEN */
select * from EMP
where SAL < 1000 or SAL > 1500;

/*  연습 문제 4
조건: 직업(JOB)이 'MANAGER'이거나 부서번호(DEPTNO)가 20인 직원 중에서, 급여(SAL)가 3000 이상인 직원만 조회하라. */
select * from EMP
where (JOB = 'MANAGER' or DEPTNO = 20)
        and SAL >= 3000;

/* 연습 문제 5
조건: 커미션(COMM)이 NULL이 아닌 직원들만 조회하라. */
select * from EMP
where COMM is not null;

/* 연습 문제 7
조건: 급여(SAL)가 1000 이상이고 부서번호(DEPTNO)가 20 이하인 직원 중에서,
직업(JOB)이 'CLERK'이거나 'SALESMAN'인 직원만 조회하라. */
select * from EMP
where (SAL >= 1000 and DEPTNO = 20)
        and JOB in('CLERK', 'SALESMAN');

/* 연습 문제 8
조건: 직원 이름(ENAME)이 'KING'이 아니고, 직업(JOB)이 'PRESIDENT'인 직원이 아닌 직원들 중에서,
부서번호(DEPTNO)가 10 또는 30인 직원만 조회하라. 단, IN 연산자는 사용하지 마세요. */
select * from EMP
where ENAME != 'KING' and JOB != 'PRESIDENT'
        and (DEPTNO = 10 or DEPTNO = 30);



/* 250514 */
-- 1. 부서 번호 10번인 사람들을 출력 
select * from EMP 
where DEPTNO = 10;

-- 2. 부서 번호 10번이 아닌 사람들을 출력
select * from EMP 
where DEPTNO != 10;

-- 3. 급여가 3000 이상인 사람들을 출력 
select * from EMP
where SAL >= 3000;

-- 4. 급여가 1500~3000 사이(포함)의 사람을 출력 
select * from EMP
where SAL between 1500 and 3000;

-- 5. 부서번호 10번인 사람 중(AND) 급여 2000 이상인 사람을 출력
select * from EMP
where DEPTNO = 10 and SAL >= 2000;

-- 6. 부서 번호 30번 중 1500~3000 사이(미포함)인 사람을 출력 
select * from EMP
where DEPTNO = 30 
        and SAL not between 1500 and 3000;

-- 7. 부서 번호 30번 중 1500~3000 사이(미포함)인 사람을 연봉이 작은 순으로 출력, 연봉이 같은 경우 이름이 빠른 순으로 출력 
select * from EMP
where DEPTNO = 30
        and (SAL > 1500 and SAL < 3000)
order by SAL asc, ENAME asc;

-- 8. 부서 번호 20,30번 중 1500~3000 사이(미포함)인 사람을 연봉이 작은 순으로 출력, 연봉이 같은 경우 이름이 빠른 순으로 출력 
select * from EMP
where DEPTNO in(20, 30)
        and (SAL > 1500 and SAL < 3000)
order by SAL asc, ENAME asc;

-- 9. 부서 번호가 20 또는 30이고 급여가 1500 이상인 직원의 이름과 급여를 급여 오름차순으로 출력하라. 
select ENAME, SAL from EMP
where DEPTNO in(20, 30)
        and SAL >= 1500
order by SAL asc;



/* 250515 */
-- Q1. 사원 이름을 총 20자 중 가운데 정렬
select ENAME,
    rpad(lpad(ENAME, 20/2+length(ENAME)/2), 20) as 가운데_정렬
from EMP;

-- Q2 : ENAME의 앞 두글자만 출력
select ENAME, substr(ENAME, 1, 2) 
from EMP;

-- Q3 : 앞의 두글자만 원본을 출력하고 나머지는 4개의 *로 표시) 
select ENAME,
        rpad(substr(ENAME, 1, 2), 6, '*') as MASKING_NAME
from EMP;

-- Q4. 사원 이름 두 글자만 보이고 나머지는 *로 , 단 원래 이름 만큼 길이 표시 
select ENAME,
        rpad(substr(ENAME, 1, 2), length(ENAME), '*') as MASKING_NAME
from EMP;



/* 250516 */
-- 복습 문제: 각 사원의 연봉을 출력
select ENAME, SAL*12 + nvl(COMM, 0) as 연봉 
from EMP;

/* 교재 179, 180쪽 문제 */
/* Q1. EMPNO 열에는 EMP 테이블에서 사원 이름이 다섯 글자 이상이며 여섯 글자 미만인 사원 정보를 출력
        MASKING_EMPNO 열에는 사원 번호 앞 두 자리 외 뒷자리를 * 기호로 출력
        MASKING_ENAME 열에는 사원 이름 첫 글자만 보여주고 나머지 글자 수 만큼 * 기호로 출력 */
-- 출력 열: EMPNO, MASKING_EMPNO, ENAME, MASKING_ENAME
select EMPNO, 
        rpad(substr(EMPNO, 1, 2), 4, '*') as MASKING_EMPNO,
        ENAME,
        rpad(substr(ENAME, 1, 1), length(ENAME), '*') as MASKING_NAME        
from EMP
where length(ENAME) >= 5 and length(ENAME) < 6;
        
/* Q2. EMP 테이블에서 사원의 월 평균 근무일 수는 21.5일이다. 하루 근무 시간을 8시간으로 보았을 때 
        사원의 하루 급여(DAY_PAY)와 시급(TIME_PAY)을 계산하여 결과를 출력.
        단, 하루 급여는 소수 셋째 자리에서 버리고, 시급은 소수 둘째 자리에서 반올림하라. */
-- 출력 열: EMPNO, ENAME, SAL, DAY_PAY, TIME_PAY 
select EMPNO, ENAME, SAL,
        trunc(SAL/21.5, 2) as DAY_PAY,
        round(SAL/21.5/8, 1) as TIME_PAY
from EMP;

/* Q3. EMP 테이블에서 사원은 입사일을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 된다.
    사원이 정직원이 되는 날짜(R_JOB)을 yyyy-mm-dd 형식으로 출력하라.
    단, 추가 수당(COMM)이 없는 사원의 추가수당은 N/A로 출력, */
-- 출력 열: EMPNO, ENAME, HIREDATE, R_JOB, COMM
select EMPNO, ENAME, HIREDATE,
        to_char(add_months(HIREDATE, 3), 'yyyy-mm-dd') as R_JOB,
        nvl(to_char(COMM), 'N/A') as COMM
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
select EMPNO, ENAME, MGR,
        case 
            when MGR is null then '0000'
            when substr(MGR, 2, 1) in('5', '6', '7', '8') 
                then rpad(substr(MGR, 2, 1), 4, substr(MGR, 2, 1))
            else '' || MGR
        end as CHG_MGR
from EMP;

/* 교재 200쪽 문제 */
/* Q1. EMP 테이블에서 부서 번호, 평균 급여(AVG_SAL), 최고 급여(MAX_SAL), 최저 급여(MIN_SAL), 사원 수(CNT)를 출력
단, 평균 급여를 출력할 때 소수는 제외하고 부서 번호별로 출력 */
-- 출력 : DEPTNO, AVG_SAL, MAX_SAL, MIN_SAL, CNT
select DEPTNO,
        trunc(avg(SAL), 0) as AVG_SAL,
        max(SAL) as MAX_SAL,
        min(SAL) as MIN_SAL,
        count(*)
from EMP
group by DEPTNO
order by DEPTNO asc;

/* Q2. 같은 직책(JOB)에 종사하는 사원이 3명 이상인 직책과 인원수를 출력하라 */
-- 출력 : JOB, COUNT(*)
select E.JOB,
        count(*)
from EMP E, DEPT D
where E.DEPTNO = D.DEPTNO
group by E.JOB
        having count(JOB) >= 3;

/* Q3. 사원의 입사 연도(HIRE_YEAR)를 기준으로 부서별로 몇 명씩 입사했는지 출력하라 */
-- 출력: HIRE_YEAR, DEPTNO, CNT
select to_char(HIREDATE, 'yyyy') as HIRE_YEAR,
        DEPTNO,
        count(*) as CNT        
from EMP
group by DEPTNO, to_char(HIREDATE, 'yyyy');

/* Q4. 추가 수당(COMM)을 받는 사원 수와 받지 않는 사원 수를 출력하라 */
-- 출력: EXIST_COMM, CNT
select nvl2(COMM, 'O', 'X') as EXIST_COMM,
        count(*)
from EMP
group by nvl2(COMM, 'O', 'X');



/* 250519(월) */
/* 교재 되새김 문제(p.226,227) */
/* Q1. 급여(SAL)가 2000을 초과한 사원의 부서 정보, 사원 정보를 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라)
출력 : DEPTNO, DNAME, EMPNO, ENAME, SAL */
-- SQL-99 이전 방식

-- SQL-99 방식


/* Q2. 부서별 평균 급여, 최대 급여, 최소 급여, 사원 수를 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라) 
출력: DEPTNO, DNAME, AVG_SAL, MAX_SAL, MIN_SAL, CNT */
-- SQL-99 이전 방식

-- SQL-99 방식


/* Q3. 모든 부서 정보와 사원 정보를 다음과 같이 부서 번호, 사원 이름순으로 정렬하여 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라) 
출력 : DEPTNO, DNAME, EMPNO, ENAME, JOB, SAL */
-- SQL-99 이전 방식

-- SQL-99 방식


/* Q4. 모든 부서 정보, 사원 정보, 급여 등급 정보, 각 사원의 직속상관 정보를 부서 번호, 사원 번호 순서로 정렬하여 출력
(단, SQL-99 이전 방식과 SQL-99 방식을 각각 사용하라) 
출력 : DEPTNO, DNAME, EMPNO, ENAME, MGR, SAL, DEPTNO_1, LOSAL, HISAL, GRADE, MGR_EMPNO, MGR_ENAME */
-- SQL-99 이전 방식

-- SQL-99 방식



/* 250520(화) */
/* 교재 되새김 문제(p.249) */
/* Q1. 전체 사원 중 ALLEN과 같은 직책(JOB)인 사원의 사원 정보, 부서 정보를 출력
출력 : JOB, EMPNO, ENAME, SAL, DEPTNO, DNAME */

/* Q2. 전체 사원의 평균 급여(SAL)보다 많이 받는 사원의 사원 정보, 부서 정보, 급여 등급 정보를 출력
(단, 출력할 때 급여가 많은 순으로 정렬하되 같다면 사원 번호를 기준으로 오름차순으로 정렬) 
출력 : EMPNO, ENAME, DNAME, HIREDATE, LOC, SAL, GRADE */

/* Q3. 10번 부서에서 근무하는 사원 중 30번 부서에 없는 직책인 사원의 사원 정보, 부서 정보를 출력
출력 : EMPNO, ENAME, JOB, DEPTNO, DNAME, LOC */


/* Q4. 직책이 SALESMAN인 사람의 최고 급여보다 많이 받는 사원의 사원 정보, 급여 등급 정보를 출력
(사원 번호 기준 오름차순으로 정렬)
출력 : EMPNO, ENAME, SAL, GRADE */
-- 다중행 함수를 사용하는 방법


-- 다중행 함수를 사용하지 않는 방법



/* 250521(수) 8일차 */
/* 복습 문제 */
-- Q1. COMM이 null인 사원을 급여 오름차순으로 정렬
select * from EMP
where COMM is null
order by SAL asc;

/* Q2. 급여 등급 별 사원 수를 등급 오름차순으로 정렬
단, 모든 등급을 표시한다 */
select S.GRADE, count(*)
from EMP E left outer join DEPT D on (E.DEPTNO = D.DEPTNO)
           left outer join SALGRADE S on (E.SAL >= S.LOSAL and E.SAL <= S.HISAL)
group by S.GRADE
order by S.GRADE asc;

/* Q3. 이름, 급여, 급여 등급, 부서 이름 조회
단, 급여 등급 3 이상만 조회. 급여 등급 내림차순, 급여 등급이 같은 경우 급여 내림차순 */
select E.ENAME, E.SAL, S.GRADE, D.DEPTNO
from EMP E left outer join DEPT D on (E.DEPTNO = D.DEPTNO)
           left outer join SALGRADE S on (E.SAL >= S.LOSAL and E.SAL <= S.HISAL)
where S.GRADE >= 3
order by S.GRADE desc, E.SAL asc;
           
/* Q4. 부서명이 SALES인 사원 중 급여 등급이 2 또는 3인 사원을 급여 내림차순으로 정렬 */
select *
from EMP E left outer join DEPT D on (E.DEPTNO = D.DEPTNO)
           left outer join SALGRADE S on (E.SAL >= S.LOSAL and E.SAL <= S.HISAL)
where D.DNAME = 'SALES'
      and S.GRADE in(2, 3)
order by E.SAL asc;