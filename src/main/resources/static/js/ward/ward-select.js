function roomChange() {

    var roomSelect = document.getElementById("room-select");
    var bedSelect = document.getElementById("bed-select");
    resetSelect(1);

    var building = $("#building-select").val();
    var floor = $("#floor-select").val();
    var room = $("#room-select").val();
    $.ajax({
        type: "get",
        url: "/ward/bed",
        data: {
            "building": building,
            "floor": floor,
            "room": room
        },
        success: function (r) {
            if (r.code === 200) {
                var beds = r.data;
                for (let i = 0; i < beds.length; i++) {
                    bedSelect.options.add(new Option(beds[i] + " 号床位", beds[i]));
                }
            }
        }
    });
}


function floorChange() {

    var floorSelect = document.getElementById("floor-select");
    var roomSelect = document.getElementById("room-select");
    resetSelect(2);

    var building = $("#building-select").val();
    var floor = $("#floor-select").val();
    $.ajax({
        type: "get",
        url: "/ward/room",
        data: {
            "building": building,
            "floor": floor
        },
        success: function (r) {
            if (r.code === 200) {
                var rooms = r.data;
                for (let i = 0; i < rooms.length; i++) {
                    roomSelect.options.add(new Option(rooms[i] + " 号房间", rooms[i]));
                }
            }
        }
    });
}


function buildingChange() {

    var buildingSelect = document.getElementById("building-select");
    var floorSelect = document.getElementById("floor-select");
    resetSelect(3);

    var building = $("#building-select").val();
    $.ajax({
        type: "get",
        url: "/ward/floor",
        data: {
            "building": building
        },
        success: function (r) {
            if (r.code === 200) {
                var floors = r.data;
                for (let i = 0; i < floors.length; i++) {
                    floorSelect.options.add(new Option(floors[i] + " 层", floors[i]));
                }
            }
        }
    });
}

function resetSelect(type) {
    var buildingSelect = document.getElementById("building-select");
    var floorSelect = document.getElementById("floor-select");
    var roomSelect = document.getElementById("room-select");
    var bedSelect = document.getElementById("bed-select");

    switch (type) {
        case 3:
            floorSelect.options.length = 0;
            roomSelect.options.length = 0;
            bedSelect.options.length = 0;
            floorSelect.options.add(new Option("请选择层号", -1));
            roomSelect.options.add(new Option("请选择房间号", -1));
            bedSelect.options.add(new Option("请选择床位", -1));
            break;
        case 2:
            roomSelect.options.length = 0;
            bedSelect.options.length = 0;
            roomSelect.options.add(new Option("请选择房间号", -1));
            bedSelect.options.add(new Option("请选择床位", -1));
            break;
        case 1:
            bedSelect.options.length = 0;
            bedSelect.options.add(new Option("请选择床位", -1));
            break;
    }


}