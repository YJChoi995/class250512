/* 250516 */
-- Q1. 사원 이름을 총 20자 중 가운데 정렬
select ENAME,
        (rpad(lpad(ENAME, 20/2 + length(ENAME)/2), 20)) as "사원 이름"
from EMP;