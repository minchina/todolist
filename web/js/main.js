$(window).ready(function(){
    var THIS = $('#new-todo');
        THIS.keydown(function(e){
        if(e.keyCode==13){
            var name = THIS.val();
            $.ajax({
                url:"/todolist_v1/add",
                data:{name:name},
                type:"POST",
                success:function(val){
                    var target = $("#todo-list");
                    target.append(concatString(val));
                    THIS.val("");
                }
            })
        }
    });

    $(".toggle").on("click",function(){
        var check_box = $(this);
        var data_id = check_box.closest("li").data("id");
        if(check_box.prop("checked")){
            $.post("/todolist_v1/todo",{type:"update",name:data_id,status:1},function(){
                check_box.closest("li").addClass("completed");
            });

        } else{
            $.post("/todolist_v1/todo", {type:"update", name: data_id, status:0}, function(){
                check_box.closest("li").removeClass("completed");
            });
        }

    });

    $("label").on("dblclick",function(){
        var $input = $(this).closest("li").addClass("editing").find('.edit');
        $input.val($input.val()).focus();
    });

    $(".edit").on("focusout",function(){
        var name = $(this).val();
        var $li = $(this).closest("li");
        var data_id = $li.data("id");
        var $label = $li.find("label");


        $.post("/todolist_v1/todo",{type:"rename",name:name,id:data_id},function(){
            $label.text(name);
            $li.removeClass("editing");
        });


    });

    $(".destroy").on("click",function(){
        var THIS = $(this).closest("li");
        var data_id = THIS.data().id;
        $.post("/todolist_v1/todo",{type:"delete",name:data_id},function(){
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

