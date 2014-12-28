$(document).ready(function(){

   var $name_input = $('#new-todo');
   $name_input.keydown(function(e){
      if(e.keyCode==13){
         var user_name = $name_input.val();
         console.log(user_name);
         $.ajax({
            url:"/todolist_v1/user",
            data:{user_name:user_name},
            type:"POST",
            success:function(user_id){
               var $user_list = $("#todo-list");
               $user_list.append(concatString(user_name,user_id));
               $name_input.val("");
            }
         })
      }
   });


   function concatString(user_name,user_id){
      var expectString =
          "<li data-id="+user_id+">"+
          "<div class='view'>"+
          "<label>"+ user_name +"</label>"+
          "<button class='destroy'></button>"+
          "</div>"+
          "<input class='edit' value='123'>"+
          "</li>";
      return expectString;
   }

});
