money = 10000

if money > 10000 :
    print("택시를 탈 수 있다")
else :
    print("택시를 탈 수 없다")


if money == 10000 :
    pass

vehicle = "택시" if money > 10000 else "걸어서"
print(vehicle)

print('*' * 20)

diner = ['회', '탕', '쉐이크']
for menu in diner : 
    print(menu)

for i, menu in enumerate(diner) :
    print(i, menu)

for i in range(2, 11) :
    print(i)

rank = [1,2,3,4,5]
result = [ i*2 for i in rank if i%2 == 0 ]
# rank의 값 하나씩 i에 넣고
# 그 값이 짝수라면 배열에 추가한다
print(result)


# 파이썬에 switch문 없음
# 파이썬 3.10 이상에서는 match
val = 'c'
match val :
    case 'a' :
        print('AA')
    case 'b' :
        print('BB')
    case 'c' :
        print('CC')
    case _ :            # _가 디폴트임
        print('default') 