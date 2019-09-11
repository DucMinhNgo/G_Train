<script>
var validation_messages = {
    "key_1": {
        "your_name": "jimmy",
        "your_msg": "hello world"
    },
    "key_2": {
        "your_name": "billy",
        "your_msg": "foo equals bar"
    }
}
for (var key in validation_messages) {
    // skip loop if the property is from prototype
    if (!validation_messages.hasOwnProperty(key)) continue;

    var obj = validation_messages[key];
    for (var prop in obj) {
        // skip loop if the property is from prototype
        if (!obj.hasOwnProperty(prop)) continue;

        // your code
        document.writeln(prop + " = " + obj[prop]+"<br>");
    }
}
</script>