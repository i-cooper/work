import math
'''
def my_abs(x):
     if not isinstance(x,(int,float)):
         raise TypeError("bad operand type")
    if x>=0:
        return x
    else:
        return -x
     
'''
def quadratic(a,b,c):
    if b*b-4*a*c<0:
        print("no result")
        return
    drta=math.sqrt(b*b-4*a*c)
    x1=(-b+drta)/(2*a)
    x2=(-b-drta)/(2*a)

    print("x1= %.2f" % x1)
    print("x2= %.2f" % x2)
    return    
    
