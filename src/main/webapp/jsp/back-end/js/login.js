//登录界面的javascript的登录格式验证


//用户登录格式
 onclick_user = function() {
    if(form_user.user.value == null || form_user.user.value == "" || !new RegExp("^\\d{9}$").test(form_user.user.value)){
        alert("账号信息格式有误或未输入!");
        form_user.user.value = "";
        form_user.user.focus();
        return;
    }
    if(form_user.password.value == null || form_user.password.value == ""){
        alert("请输入密码信息!");
        form_user.password.value = "";
        form_user.password.focus();
        return;
    }
    form_user.submit();
}

//管理员登录格式
function onclick_admin() {
    if(t_admin.id.value == null || t_admin.id.value == "" || !new RegExp("^\\d{9}$").test(t_admin.id.value)){
        alert("管理员账号未输入或输入格式不正确!");
        t_admin.id.value = "";
        t_admin.id.focus();
        return;
    }
    if(t_admin.password.value == null || t_admin.password.value == ""){
        alert("请输入管理员密码!");
        t_admin.password.value = "";
        t_admin.password.focus();
        return;
    }
    t_admin.submit();
}