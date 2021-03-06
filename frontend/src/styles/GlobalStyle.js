import {createGlobalStyle} from 'styled-components'

export default createGlobalStyle`
*{
    padding: 0;
    margin: 0;
    background: #141414;
    color: #FFF;
    font-family: Helvetica, sans-serif;
}

#root {
    position: fixed;
    width: 100vw;
    height: 100vh;
}
`