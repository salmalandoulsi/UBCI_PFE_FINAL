$(function() {
    $('.video-background').videoBG({
        mp4:'../assets/dummy-images/video/big-buck-bunny.mp4',
        ogv:'../assets/dummy-images/video/big-buck-bunny.ogv',
        webm:'../assets/dummy-images/video/big-buck-bunny.webm',
        poster:'../assets/dummy-images/455293175_1280.jpg',
        scale:false,
        opacity:0.85,
        position: "absolute",
        zIndex:0
    });
});

$(function() {
    $('.video-background-4').videoBG({
        mp4:'../assets/dummy-images/video/big-buck-bunny.mp4',
        ogv:'../assets/dummy-images/video/big-buck-bunny.ogv',
        webm:'../assets/dummy-images/video/big-buck-bunny.webm',
        poster:'../assets/dummy-images/455293175_1280.jpg',
        scale:false,
        opacity:0.85,
        position: "absolute",
        zIndex:0
    });
});

$(function() {
    $('.video-background-2').videoBG({
        mp4:'../assets/dummy-images/video/big-buck-bunny.mp4',
        ogv:'../assets/dummy-images/video/big-buck-bunny.ogv',
        webm:'../assets/dummy-images/video/big-buck-bunny.webm',
        poster:'../assets/dummy-images/455293175_1280.jpg',
        scale:false,
        opacity:0.45,
        //position: "absolute",
        zIndex:0
    });
});

$(function() {
    $('.video-background-3').videoBG({
        mp4:'../assets/dummy-images/video/big-buck-bunny.mp4',
        ogv:'../assets/dummy-images/video/big-buck-bunny.ogv',
        webm:'../assets/dummy-images/video/big-buck-bunny.webm',
        poster:'../assets/dummy-images/455293175_1280.jpg',
        scale:false,
        opacity:0.45,
        //position: "absolute",
        zIndex:0
    });
});

$('video,audio').each(function(){this.muted=true})