function passwordEncrypt() {
    var username = $("#stuUsername").val();
    var remember = $("#remember").val();
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey($("#publicKey").val());
    var _pwd = encrypt.encrypt($("#password").val());
    var pwd = encodeURI(_pwd).replace(/\+/g, '%2B');
    $('#stuPassword').val(pwd);


//异步校验用户名是否已经注册
//这是个疑问要解决!!!

    $.ajax({
        url: "/yxw/loginIn",
        data: {
            "stuUsername": username,
            "stuPassword": pwd,
            "remember": remember
        },
        type: "POST",
        dataType: "json",
        success: function (result) {
            alert(result);
            if (result == 1) {
                window.location.href = '/yxw/index';
            } else {
                alert("登录失败:" + result);
            }

        },
        error: function (result) {
            alert("error出问题")
            if (result.status == '200') {
                window.location.href = '/index';
            } else {
                alert("登录失败:" + result);
            }
        }
    })
}

function passwordEncryptReg(){
    var username = $("#stuUsername").val();
    var remember = $("#remember").val();
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey($("#publicKey").val());
    var _pwd = encrypt.encrypt($("#password").val());
    var pwd = encodeURI(_pwd).replace(/\+/g, '%2B');
    $('#stuPassword').val(pwd);

}