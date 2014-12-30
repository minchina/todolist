$(document).ready(function(){

   var $name_input = $('#new-todo');
   $name_input.keydown(function(e){
      if(e.keyCode==13){
         var user_name = $name_input.val();
         $.ajax({
            url:"/todolist_v1/user",
            data:{user_name:user_name},
            type:"POST",
            success:function(json_user){
               var user = JSON.parse(json_user);
               var $user_list = $("#todo-list");
               $user_list.append(concatString(user.name,user.id));
               $name_input.val("");
            }
         })
      }
   });

   function concatString(user_name,user_id){
      var expectString =
          "<li data-id="+user_id+">"+
            "<div class='view'>"+
                "<a href='user/"+user_name+"/todos>"+user_name+"</a>"+
                "<button class='destroy'></button>"+
            "</div>"+
            //"<input class='edit' value='123'>"+
          "</li>";
      return expectString;
   }

});
