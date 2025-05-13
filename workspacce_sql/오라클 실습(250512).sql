/* 250512 */
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


/* 250513 */
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