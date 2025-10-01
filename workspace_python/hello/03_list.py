# list (변수명 = [..., ..., ...])

a = ['영', '일', '이', '삼', '사']
print( a[-2])

# 배열 초기화
b = [1,2,3,4]
b = []
b = list()

# slice 슬라이싱
print(1, a[0:2] ) # 0부터 2 바로 앞까지
print(2, a[1:2] )
print(3, a[1:20] ) # 마지막 index가 커도 배열의 끝까지만
print(4, a[10:20] ) # 에러 없음
print(5, a[100:20] ) # 에러 없음

print(6, a[1:] ) # 1부터 끝까지
print(7, a[:3] ) # 처음부터 3까지

# 배열 합치기
c = [1,2,3]
d = [4,5,6]
print (c + d)

del a[1] # 지우기 (처음부터 끝까지)

# range
## range(시작숫자, 종류숫자, step)
## 시작 숫자부터 종료 숫자 바로 앞까지 step씩 증가하면서
e = range(10)
print(1, e)
print(2, list(e))
print(3, list( range(4, 10, 2) ))
print(3, list( range(40, 10, 2) )) # 종료 숫자가 크면 비어있음
print(3, list( range(40, 10, -2) )) # step은 음수 가능