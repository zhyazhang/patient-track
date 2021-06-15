function isNumber(value) {         //验证是否为数字

    var patrn = /^(-)?\d+(\.\d+)?$/;

    if (value !== "admin") {
        if (patrn.exec(value) == null || value == "") {
            return false
        } else {
            return true
        }
    } else {
        return true;
    }


}