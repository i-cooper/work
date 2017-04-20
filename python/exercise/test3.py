'''
import math

def move(x,y,step,angle=0):
    nx=x+step*math.cos(angle)
    ny=y-step*math.sin(angle)
    return nx,ny
'''
def power(x,n=2):
    s=1
    while n>0:
        s=s*x
        n=n-1
    return s
    
