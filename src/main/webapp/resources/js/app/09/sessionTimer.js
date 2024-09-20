const SPEED = 1000;
const timeFormat = (timeout)=>{
    let min = Math.trunc(timeout/60);
    let sec = timeout%60;
    return `${min}분 : ${sec}초`;
}

function SessionTimer(element, timeout){
    
    const cerateMessage = ()=>{
        let msgDiv = document.createElement("div")
        msgDiv.innerHTML = `
        <p>세션 연장 여부</p>
        <button class="yes-btn">예</button>
        <button>아니요</button>
        `; 
        msgDiv.addEventListener("click", (e)=>{
            if(e.target.tagName.toLowerCase()!="button") return;
            if(e.target.classList.contains("yes-btn")){
                console.log("yes버튼 클릭", this)
                this.reset();
            }
            msgDiv.remove();
        });
        return msgDiv;
    };
    this.init = ()=>{
        fetch("", {method:"head"});
        this.timerValue = timeout;
        element.innerHTML = timeFormat(this.timerValue)
        this.msgJob =  setTimeout(()=>{
            this.msgDiv = cerateMessage();
            document.body.appendChild(this.msgDiv);
        }, (timeout-60)*SPEED)
        this.timerJob = setInterval(()=>{
            if(this.timerValue > 0){
                element.innerHTML = timeFormat(--this.timerValue);
            } else {
                this.destroy();
            }
        }, SPEED);
    }
    this.reset = ()=>{
        clearInterval(this.timerJob);
        clearTimeout(this.msgJob);
        this.init();
    }
    this.destroy = ()=>{
        clearInterval(this.timerJob);
        clearTimeout(this.msgJob);
        //세션이 만료된 이후 웰컴페이지 로 이동.
//        location.href=`${document.body.dataset.contextPath}/`; //2분동안 아무것도 안하면 로그아웃하고 웰컴페이지로 넘긴다
		location.reload();
    }
}

document.addEventListener("DOMContentLoaded", ()=>{
    let timerTags = document.querySelectorAll("[data-st-timer]");
    const singleFunc = singleTag => {
        const timeout = singleTag.dataset.stTimer;
        let timer = new SessionTimer(singleTag, timeout);
        timer.init();
    };
    timerTags.forEach(singleFunc)
});

// 1분남을때 버튼 2개 
//세션 연장 아니오
// 그 두개 이벤트 처리
// 연장할때 타이머는 다시 2분부터
//메세지는 사라지게
