$(document).ready(function(){
    $("#init").click(function(){
        var nameStr = "";
        $("input[name='file']:checked").each(function(){
            nameStr += $(this).val() + "_";
        });
        $.ajax({
            type : "POST",
            url : "initFile",
            data : {
                'nameStr' : nameStr
            },
            success : function(){
                alert("生成html成功");
            }
        });
    });
});