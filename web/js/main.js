/**
 * Created by minchina on 14-12-23.
 */
$(window).ready(function(){
    $('#new-todo').keydown(function(e){
        if(e.keyCode==13){//这是一个回车事件
            console.log($("#new-todo").val());
        }
    });
})