/**
 * Created by minchina on 14-12-23.
 */
$(window).ready(function(){
    $('#new-todo').keydown(function(e){
        if(e.keyCode==13){//这是一个回车事件
            var val = $("#new-todo").val();
            $.post("/todolist_v1/qin",{name:val},function(data){
                alert("success" + "  "+data);
            })
        }
    });
});