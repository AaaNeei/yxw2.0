$(function () {
    $('#loginIn').click(function () {
        var username = $("#username").val();
        var remember = $("#remember").val();
        var encrypt = new JSEncrypt();
        encrypt.setPublicKey($("#publicKey").val());
        var _pwd = encrypt.encrypt($("#password").val());
        var pwd = encodeURI(_pwd).replace(/\+/g, '%2B');
        //异步校验用户名是否已经注册
        $.ajax({
            url: "/yxw/loginIn",
            data: {
                "stuUsername": username,
                "stuPassword": pwd,
                "remember": remember
            },
            type: "POST",
            dataType: "json",
            success: function (msg) {


            },
            error: function () {
            }
        })

    });
});