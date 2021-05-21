import styled from 'styled-components'

export const HomeStyle = styled.main`
    
    main{
        width: 100vw;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;

        div{
            display: block; 
            text-align: center;
            margin-top: 50px;
            height: 80%;

            & > div {
                color: #FFF;
                font-size: 3.5vw;
                height: 50px;
            }

            ul{
                padding: 0;
                display: flex;
                align-items: center;
                list-style: none;

                li{
                    display: block;
                    padding: 0px 15px 80px 15px;
                    
                    img {
                        display: flex;
                        max-width: 139px;
                        max-height: 139px;
                        border-radius: 4px;
                        padding-bottom: 10px;
                    }

                    span {
                        color: grey;
                        border: 0;
                        font-size: 1.3vw;
                        letter-spacing: .5px;
                    }
                }
            }
            & > span {
                font-size: 1.2vw;
                text-align: center;
                color: grey;
                border: grey solid 1px;
                padding: .5em 1.5em;
                letter-spacing: 2px;
            }
        }
    }

`