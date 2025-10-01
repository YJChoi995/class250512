tft = {
    'health': 98,
    'money': 50,
    'level': 8,
    'name': 'VI'
}

print (tft)
# print(tft.health)
print(tft['health'])

tft['health'] = 87

print( len(tft ))

# print( tft['health2'] )

print( 'level' in tft ) # key가 있는지 확인

print( 'items', tft.items() )
print( 'keys', tft.keys() )
print( 'values', tft.values() )

print( tft.get('money') )
print( tft.get('money2') )  # 없으면 None이 나온다
print( tft.get('money2', 0) )  # 없으면 None 대신 다른거 -> NVL 개념

a = {1,2,3}
print(a)
print( type(a) )
