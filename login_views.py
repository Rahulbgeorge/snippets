from django.shortcuts import render,HttpResponseRedirect,HttpResponse
from django.contrib.auth.models import User
from django.contrib import auth

# Create your views here.

def registration(request):
    user_info={}
    if request.method=="POST":
        user_info["username"]=request.POST['username']
        user_info["password"]=request.POST['password1']
        user_info["password1"]=request.POST['password2']
        user_info["email"]=request.POST["email"]
        user_info["first_name"]=request.POST["firstname"]
        user_info["last_name"]=request.POST["lastname"]
        valid=validate_password(user_info['password'],user_info['password1'])
        if valid:
            user=User.objects.create_user(username=user_info['username'],first_name=user_info['first_name']
            ,last_name=user_info['last_name'],email=user_info['email'],password=user_info['password'])
            user.save()
            return HttpResponseRedirect("/login/")
        else:
            return HttpResponse("fail")

    return render(request,"user_access/registration.html")
        
    

def logout(request):
    auth.logout(request)
    return HttpResponseRedirect("/login")
        
def login(request):
    if request.method=="POST":
        username,password=request.POST['username'],request.POST['password']
        user=auth.authenticate(username=username,password=password)
        if(user is not None):
            auth.login(request,user)
            return HttpResponseRedirect("/home")
        else:
            return HttpResponse("fail")
    
    return render(request,"user_access/login.html")

def validate_password(password1, password2):
    return(password1==password2)


        
