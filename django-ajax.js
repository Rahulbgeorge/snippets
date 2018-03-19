 $.ajaxSetup({
        headers: { "X-CSRFToken": getCookie("csrftoken") }
            });


           $.ajax(

               { csrfmiddlewaretoken: ['{{ csrf_token }}'],
               type:"POST",
               url:"",
               data:{username:data[0],password1:data[1],password2:data[2],firstname:data[3],lastname:data[4],email:data[5]},
               datatype:"html"


               }
           ).done(function(response){
               //do nothing
               alert(response);
           });


           function getCookie(val)
           {
               var csrftoken=document.cookie;
               csrftoken=csrftoken.slice(10);
               return csrftoken
           
           }

/*

Here we setup thee ajax for djangos security features firs
the getCookie is supposed to be a inbuilt method, but if not found the 
manually inplemented getCookie function can be used

url: This is where you specify the page/ address to which you are posting content
data: this is a dictionary of any content which is to be send to the backend



This is the corresponding methodology used  in django to access the recieved data


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


*/