def reverseArr(arr):
    start = 0
    last = len(arr)-1
    while(start < last):
        arr[start] , arr[last] = arr[last] , arr[start]
        start +=1
        last -=1
    
    for i in arr: 
        print(" : ",i)
       
array = [10,20,30,40,50,60,70,80]  
reverseArr(array)  