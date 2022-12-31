/**
 * 댓글 
 */
const $modifyButtons = $("div.modify-button");
const $deleteButtons = $("div.delete-button");
let check = true;

show();

function show(){
	$.ajax({
		url: "/reply/listOk.re",
		type: "get",
		data: {boardNumber: boardNumber},
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: showList
	});
}


function showList(replies){
	if(replies.length > 0){
		let text = "";
		
		replies.forEach(reply => {
			text += `<div class = "reply">`;
			text += `<div class="info">`;
			text += `<p class = "writer">` + reply.memberId + `</p>`;
			text += `<p class = "date">` + reply.replyDate + `</p>`;
			text += `</div>`;
			text += `<div class="content" style="width:100%">`;
			text += `<pre>` + reply.replyContent + `</pre>`;
			text += `</div>`;
			if(reply.memberId == memberId){
				text += `<div class ="button-wrap">`;
				text += `<div class="modify-ready-button" data-number=` + reply.replyNumber +`></div>`;								
				text += `<div class="modify-button" data-number=` + reply.replyNumber +` style = "display:none;"></div>`;								
				text += `<div class="delete-button" data-number=` + reply.replyNumber +`></div>`;								
				text += `<div class="cancel-button" data-number=` + reply.replyNumber +` style = "display:none;"></div>`;								
				text += `</div>`;
			}
			text += `</div>`;
		});
		
		$("#replies").html(text);
	}
}

function upload(){
	let replyContent = uploadForm.replyContent.value;
	 if(!uploadForm.replyContent.value){
          alert("댓글을 작성해주세요.");
          return;
       }
		
               
	//**합쳐서 사용했는데, 그보다 목록을 불러오는 ajax를 함수로 만들어서 계속 사용하는 쪽으로 생각한다., */
	$.ajax({
		url:"/reply/writeOk.re",
		type: "get",
		data: {boardNumber: boardNumber, replyContent : replyContent, memberNumber : memberNumber},
		contentType : "application/json; charset=utf-8",
		success: function(){
			show();
			}
		});
 }


// 이벤트 위임
//미리 작성된 HTML 태그에 이벤트를 부여하고, DOM으로 추가될 자식에게 이벤트를 위임해준다.
//잔뜩 누르면 에러남 4개...?
$('#replies').on('click', "div.delete-button", function(){
		let replyNumber = $(this).data("number");
		
		$.ajax({
		url:"/reply/deleteOk.re",
		type: "get",
		data: {replyNumber : replyNumber},
		contentType : "application/json; charset=utf-8",
		success: function(){
			show();
			}
		});
	
});

$('#replies').on('click', "div.modify-ready-button", function(){
	if(!check){alert("이미 수정중인 댓글이 있습니다."); return;}
	check = false;
	
	const buttonsWrap = $(this).closest(".button-wrap").children();
	const buttons = buttonsWrap.children();
	const content = buttonsWrap.prev().find(":first-child");
	
	buttons[0].eq().show();
	buttons[1].eq().hide();
	buttons[2].eq().show();
	buttons[3].eq().hide();
	
//	해당 자리에 태그를 변환시킴
	content.replaceWith("<textarea></textarea>")
	});
	
$('#replies').on('click', "div.cancel-button", function(){
	const buttonsWrap = $(this).closest(".button-wrap").children();
	const buttons = buttonsWrap.children();
	const content = buttonsWrap.prev().find(":first-child");
	
	buttons[0].eq().show();
	buttons[1].eq().hide();
	buttons[2].eq().show();
	buttons[3].eq().hide();
	
//	해당 자리에 태그를 변환시킴
	content.replaceWith("<pre>context.text()</pre>")
	});


$('#replies').on('click', "div.modify-button", function(){
	const buttonsWrap = $(this).closest(".button-wrap").children();
	let replyNumber = $(this).data("number");
	const content = buttonsWrap.prev().find(":first-child");
		
		$.ajax({
		url:"/reply/deleteOk.re",
		type: "get",
		data: {replyNumber : replyNumber, replyContent : content.val()},
		contentType : "application/json; charset=utf-8",
		success: function(){
			show();
			check = true;
			}
		});
});