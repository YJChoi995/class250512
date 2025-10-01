
# main() # 선언 전에 실행 안됨
def main(val) :
    global a
    try :
        # print(123)
        a = 20
        print(a)
    except Exception as e :
        print(f'오류발생: {e}')
    finally :
        print('항상 실행')

def test() :
    print('test')

if __name__ == '__main__':
    main(1)

print('after a: ', a)
print(__name__)