$(window).ready(function(){
    $('#new-todo').keydown(function(e){
        if(e.keyCode==13){//这是一个回车事件
            var val = $("#new-todo").val();
            $.post("/todolist_v1/todo", {name:val}, function(data){
                var target = $("#todo-list");
                target.append(concatString(data));
            })
        }
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

