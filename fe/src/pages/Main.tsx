import styled from "styled-components";
export const MainPage = () => {
  return (
    <Content>
    </Content>
  );
};

const Content = styled.div`
  border: ${({ theme: { border } }) => border.default};
  border-color: ${({ theme: { color } }) => color.nuetralBorderDefault};
  border-radius: ${({ theme: { radius } }) => radius.large};
`;
