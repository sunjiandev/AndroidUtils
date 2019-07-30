package com.sunkaisens.androidutils;

/**
 * @author:sjy
 * @date:2019-07-26
 * @email:sjy_mail@163.com
 * @Description:
 */
public class ContentItem {

    private String authorIconUri;
    private String authorName;

    private String content;

    private String contentUri;

    /**
     * 笑脸
     */
    private String statsVote;

    /**
     * 评论数
     */
    private String statsComments;

    /**
     * 评论uri
     */
    private String statsCommentsUri;

    private CmtMain main;

    public String getAuthorIconUri() {
        return authorIconUri;
    }

    public void setAuthorIconUri(String authorIconUri) {
        this.authorIconUri = authorIconUri;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentUri() {
        return contentUri;
    }

    public void setContentUri(String contentUri) {
        this.contentUri = contentUri;
    }

    public String getStatsVote() {
        return statsVote;
    }

    public void setStatsVote(String statsVote) {
        this.statsVote = statsVote;
    }

    public String getStatsComments() {
        return statsComments;
    }

    public void setStatsComments(String statsComments) {
        this.statsComments = statsComments;
    }

    public String getStatsCommentsUri() {
        return statsCommentsUri;
    }

    public void setStatsCommentsUri(String statsCommentsUri) {
        this.statsCommentsUri = statsCommentsUri;
    }

    public CmtMain getMain() {
        return main;
    }

    public void setMain(CmtMain main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "ContentItem{" +
                "authorIconUri='" + authorIconUri + '\'' +
                ", authorName='" + authorName + '\'' +
                ", content='" + content + '\'' +
                ", contentUri='" + contentUri + '\'' +
                ", statsVote='" + statsVote + '\'' +
                ", statsComments='" + statsComments + '\'' +
                ", statsCommentsUri='" + statsCommentsUri + '\'' +
                ", main=" + main +
                '}';
    }
}
