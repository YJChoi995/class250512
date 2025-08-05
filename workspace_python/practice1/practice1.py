print("Hello, World")
# 주석
''' 
범위 
주석 
'''

# 변수 선언하기
a = 5
print(a)
b = 3
print(a, b)

# 변수의 타입
a = 5
b = 1.3
c = "Hello"
d = True
e = None

print(type(a))
print(type(b))
print(type(c))
print(type(d))
print(type(e))

# 연산자
# 나눗셈('/') 연산을 수행하면 결과가 무조건 float로 바뀐다
a = 10/2
print(a) # 5.0
# 문자열끼리 더하면 두글자 그대로 이어붙게 된다
a = "Hello"
b = "World"
print(a + b)
# 타입이 다른 것끼리 연산하면 에러가 난다
# 이럴 경우 타입변환 후 가능하게 됨
a = 5
b = "3"
print(a + int(b)) # 8

# / : 나눗셈, // : 나눗셈 결과의 몫
# * : 곱셈, ** : 제곱

# 변수 이름
''' - 변수 이름은 영어와 숫자, 언더바(_)만을 사용(한글, 특수기호 불가)
    - 변수 이름은 영어와 언더바(_)로만 시작 가능
    - 변수 이름은 대소문자를 구분한다
'''

# ---------------------------------------

''' 함수'''
''' 함수 선언 (definition) '''
# def name(a):
def function1(a):
    print(a)

function1("function1: Hello")

# 입력 인자를 받지 않을 수 있음
def function2():
    print("A")

function2()

def function3(a, b, c):
    print(a+b+c)

function3(1,2,3) #6
function3("hello", " ", "world") #hello world

# 입력 인자의 타입을 고정할 수 있다
def function4(a: int, b: int, c: int):
    print(a+b+c)

function4(2,4,6) #12


# 입력 인자는 기본값을 지정할 수 있다
def function5(a=3, b=5):
    print(a+b)

function5() #8

# 타입 지정과 기본값 지정을 동시에 할 수 있다
def function6(a: int = 3, b: int =5):
    print(a+b)

function6()

''' 함수 내부와 외부 '''
# 함수는 들여쓰기를 통해 내부와 외부를 구분한다
# "함수의 외부입니다"가 먼저 출력됨. 함수 안에 들어있는 것을 '들여쓰기'라고 함
def functionA():
    print("함수의 내부입니다")

print("함수의 외부입니다")
functionA()

''' 함수의 출력 '''
# return을 통해 출력할 값을 결정할 수 있다
def functionB():
    a = 3
    b = 5
    c = 7
    return b

result = functionB()
print(result)

''' 서로 다른 함수간의 관계 '''
# 함수 안에서 다른 함수를 사용할 수 있다
def PlusFunction(a, b):
    return a + b

def functionC(a,b,c):
    res = PlusFunction(a,b)
    res *= c
    return res

print(functionC(2,3,4))

# 함수 안에서 다른 함수를 선언 할 수 있다