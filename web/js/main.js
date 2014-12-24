$(window).ready(function(){
    var THIS = $('#new-todo');
        THIS.keydown(function(e){
        if(e.keyCode==13){//这是一个回车事件

            var val = THIS.val();
            $.post("/todolist_v1/todo", {type:"add",name:val}, function(data){
                var target = $("#todo-list");
                target.append(concatString(data));
                THIS.val("");
            })
        }
    });
    $(".destroy").on("click",function(){
        var THIS = $(this).closest("li");
        var data_id = THIS.data().id;
        $.post("/todolist_v1/todo",{type:"delete",name:data_id},function(){
            console.log("hehehaha");
            THIS.remove();
        });

    });

    function concatString(data){
        var expectString =
            "<li data-id='bf086285-4746-4772-acf3-266e6ba1eb4f'>"+
                "<div class='view'>"+
                    "<input class='toggle' type='checkbox'>"+
                    "<label>"+ data +"</label>"+
                    "<button class='destroy'></button>"+
                "</div>"+
                "<input class='edit' value='123'>"+
            "</li>";
        return expectString;
    }
});

