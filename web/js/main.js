$(window).ready(function(){
    var THIS = $('#new-todo');
        THIS.keydown(function(e){
        if(e.keyCode==13){//这是一个回车事件

            var val = THIS.val();
            $.post("/todolist_v1/todo", {type:"add",name:val}, function(val){
                console.log(val);
                var target = $("#todo-list");
                target.append(concatString(val));
                THIS.val("");
            })
        }
    });

    $(".toggle").on("click",function(){

        var check_box = $(this);
        if(check_box.prop("checked")){
            check_box.closest("li").addClass("completed");
        }else{
            check_box.closest("li").removeClass("completed");

        }
    });
    $(".destroy").on("click",function(){
        var THIS = $(this).closest("li");
        var data_id = THIS.data().id;
        console.log(data_id);
        $.post("/todolist_v1/todo",{type:"delete",name:data_id},function(){
            console.log("hehehaha");
            THIS.remove();
        });

    });

    function concatString(val){
        var expectString =
            "<li data-id="+"12"+">"+
                "<div class='view'>"+
                    "<input class='toggle' type='checkbox'>"+
                    "<label>"+ val +"</label>"+
                    "<button class='destroy'></button>"+
                "</div>"+
                "<input class='edit' value='123'>"+
            "</li>";
        return expectString;
    }
});

