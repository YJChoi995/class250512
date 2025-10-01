l = [1,2,3]
t = (1,2,3)
l[0] = 10
print(t[0])
# t[0] = 3 # 불가. tuple은 값을 바꿀 수 없는 리스트이다 


t1 = 1,2,3
print(t1)
print( type(t1) )

t2 = 1    # 그냥 int 1
t3 = (1)  # 그냥 int 1
t4 = (1,) # 한개짜리 튜플
t5 = 1    # () 생략 가능

t6 = tuple( range(4) )
print(t6)
# print(t6[10])

print( list('hello') )
print( tuple('hello') )