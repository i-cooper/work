# -*- coding: utf-8 -*-
# pram
def power(x,n=2):
    s=1
    enroll('li','nan')

    num=[1,2,3,4]
    cal(*num)
    person('lee',67,city="sh",gender="boy")
    '''
    while n>0:
        s=s*x
        n=n-1
    return s
''' 

def enroll(name,gender,age=6,city='Beijing'):
    print("name:",name)
    print("gender:",gender)
    print("age:",age)
    print("city:",city)

    
def cal(*number):
    s=0
    for n in number:
        s=s+n
    print ("cal:",s)
    return None
def person(name,age,**kw):
    print("name:",name,"age:",age,"other:",kw)
